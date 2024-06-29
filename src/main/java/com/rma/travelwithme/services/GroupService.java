package com.rma.travelwithme.services;

import com.rma.travelwithme.models.Group;
import com.rma.travelwithme.models.Invitation;
import com.rma.travelwithme.models.User;
import com.rma.travelwithme.repositories.GroupRepository;
import com.rma.travelwithme.repositories.UserRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final MailSenderService mailSenderService;

    public GroupService(GroupRepository groupRepository, UserRepository userRepository, MailSenderService mailSenderService) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.mailSenderService = mailSenderService;
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Long groupId) {
        return groupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id " + groupId));
    }

    public Group createGroup(Group group) {

        Set<String> emailList = group.getListOfJoiners()
                .stream()
                .map(Invitation::getEmail)
                .collect(Collectors.toSet());

        mailSenderService.sendSimpleMessage(emailList, group.getGroupId(), group.getName());

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
        Group savedGroup = groupRepository.save(group);

        mailSenderService.sendSimpleMessage(group.getListOfJoinersEmails(), savedGroup.getGroupId(), savedGroup.getName());
    }

    public List<Group> getAllGroupsByUserId(Long userId) {
        User user = userRepository.findById(userId).get();
        return groupRepository.findByGroupLeader(user);
    }

    public static long calculateDaysBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null)
            return 0;
        else {
            LocalDate startLocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
        }
    }
    public void deleteAllGroups() {
    groupRepository.deleteAll();
}
}