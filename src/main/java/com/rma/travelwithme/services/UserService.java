package com.rma.travelwithme.services;

import com.rma.travelwithme.models.User;
import com.rma.travelwithme.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Service methods to interact with UserRepository
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

        user.builder()
                .username(userDetails.getUsername())
                .password(userDetails.getPassword())
                .email(userDetails.getEmail())
                .firstName(userDetails.getFirstName())
                .lastName(userDetails.getLastName())
                .groupLeader(userDetails.isGroupLeader())
                .build();
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        userRepository.delete(user);
    }
    
    public User authenticateUser(String username, String password) throws Exception {
    	return userRepository.findByUsernameAndPassword(username, password);
    }
    // You can add more service methods as needed
}

