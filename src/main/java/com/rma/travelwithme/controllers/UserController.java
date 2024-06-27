package com.rma.travelwithme.controllers;

import com.rma.travelwithme.models.User;
import com.rma.travelwithme.requests.LoginRequest;
import com.rma.travelwithme.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
        User user = userService.getUserById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {
//        User updatedUser = userService.updateUser(userId, userDetails);
//        return ResponseEntity.ok(updatedUser);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/login")
    public ResponseEntity<User> authenticateUser(@RequestBody LoginRequest loginRequest) throws Exception {
            User user = userService.authenticateUser(loginRequest);
            return ResponseEntity.ok(user);

    	
    }
    // You can add more controller methods as needed

}

