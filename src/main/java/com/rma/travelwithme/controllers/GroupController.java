package com.rma.travelwithme.controllers;

import com.rma.travelwithme.models.Group;
import com.rma.travelwithme.services.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        Group group = groupService.getGroupById(id);
        return ResponseEntity.ok().body(group);
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable Long id, @RequestBody Group groupDetails) {
        Group updatedGroup = groupService.updateGroup(id, groupDetails);
        return ResponseEntity.ok().body(updatedGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/createGroupByUserId/{userId}")
    public ResponseEntity<?> createGroupByUserId(@RequestBody Group group,@PathVariable Long userId) throws Exception {
        //System.out.println(emails);
    	groupService.createGroupByUserId(group, userId);
        return ResponseEntity.ok("Group created successfully");
    }
    @GetMapping("/allByUserId/{userId}")
    public ResponseEntity<?> findGroupsByUserId(@PathVariable Long userId){
    	List <Group> groupList = groupService.getAllGroupsByUserId(userId);
    	return  ResponseEntity.ok(groupList);
    }
}