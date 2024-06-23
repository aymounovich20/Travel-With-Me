package com.rma.travelwithme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.rma.travelwithme.models.Group;
import com.rma.travelwithme.models.User;
import com.rma.travelwithme.repositories.GroupRepository;
import com.rma.travelwithme.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    // Service methods to interact with GroupRepository
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
    

    public void createGroup(Group group, Long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (!user.isGroupLeader()) {
            throw new Exception("User is not authorized to create groups");
        }

        // Create group logic
        group.setGroupLeader(user);
        groupRepository.save(group);
    
    }

    public Optional<Group> getGroupById(Long groupId) {
        return groupRepository.findById(groupId);
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group updateGroup(Long groupId, Group groupDetails) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group not found with id " + groupId));
        group.setGroupName(groupDetails.getGroupName());
        group.setGroupLeader(groupDetails.getGroupLeader());
        group.setCreatedDate(groupDetails.getCreatedDate());
        return groupRepository.save(group);
    }

    public void deleteGroup(Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group not found with id " + groupId));
        groupRepository.delete(group);
    }
    // You can add more service methods as needed
}

