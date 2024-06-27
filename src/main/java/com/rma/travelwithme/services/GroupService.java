package com.rma.travelwithme.services;

import com.rma.travelwithme.models.Group;
import com.rma.travelwithme.models.User;
import com.rma.travelwithme.repositories.GroupRepository;
import com.rma.travelwithme.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Long groupId) {
        return groupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id " + groupId));
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group updateGroup(Long groupId, Group groupDetails) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id " + groupId));
        group.setName(groupDetails.getName());
        return groupRepository.save(group);
    }

    public void deleteGroup(Long groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id " + groupId));
        groupRepository.delete(group);
    }

    public void createGroupByUserId(Group group, Long userId) {
    	User user = userRepository.findById(userId).get();
    	group.setGroupLeader(user);
    	groupRepository.save(group);
    }
    public List<Group> getAllGroupsByUserId(Long userId){
    	User user = userRepository.findById(userId).get();
    	return groupRepository.findByGroupLeader(user);
    }
}