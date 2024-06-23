package com.rma.travelwithme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rma.travelwithme.models.Group;
import com.rma.travelwithme.services.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;
    

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }
    @PostMapping("/createGroupByUserId")
    public ResponseEntity<?> createGroupByUserId(@RequestBody Group group,@RequestBody Long userId) throws Exception {
        //Long userId = getUserIdFromPrincipal(principal); // Implement this method to get userId from principal

        groupService.createGroup(group, userId);

        return ResponseEntity.ok("Group created successfully");
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable(value = "id") Long groupId) {
        Group group = groupService.getGroupById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group not found with id " + groupId));
        return ResponseEntity.ok().body(group);
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable(value = "id") Long groupId, @RequestBody Group groupDetails) {
        Group updatedGroup = groupService.updateGroup(groupId, groupDetails);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable(value = "id") Long groupId) {
        groupService.deleteGroup(groupId);
        return ResponseEntity.noContent().build();
    }

//    private Long getUserIdFromPrincipal(Principal principal) {
//        // Extract userId from principal (depends on your implementation)
//        // Example:
//        // return userService.getUserIdByUsername(principal.getName());
//        return null;
//    }
    // You can add more controller methods as needed
}
