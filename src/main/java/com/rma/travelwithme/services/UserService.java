package com.rma.travelwithme.services;

import com.rma.travelwithme.configurations.PasswordAES;
import com.rma.travelwithme.models.User;
import com.rma.travelwithme.repositories.UserRepository;
import com.rma.travelwithme.requests.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PasswordAES passwordAES256;

    // Service methods to interact with UserRepository
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        // Check if username is already in use
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already in use");
        }

        // Encode password before saving
        System.out.println(user.getPassword());
        user.setPassword(passwordAES256.encrypt(user.getPassword()));
        return userRepository.save(user);
    }

//    public User updateUser(Long userId, User userDetails) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
//
//        user.builder()
//                .username(userDetails.getUsername())
//                .password(userDetails.getPassword())
//                .email(userDetails.getEmail())
//                .firstName(userDetails.getFirstName())
//                .lastName(userDetails.getLastName())
//                .groupLeader(userDetails.isGroupLeader())
//                .build();
//        return userRepository.save(user);
//    }

    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        userRepository.delete(user);
    }
    
	public User authenticateUser(LoginRequest loginRequest) throws Exception {
		Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
		if(!user.isPresent()) {
			throw new Exception("Incorrect Username");
		}
		String decryptedPassword = passwordAES256.decrypt(user.get().getPassword());
		System.out.println(decryptedPassword);
		if (!decryptedPassword.equals(loginRequest.getPassword())) {
			throw new Exception("Invalid credentials");
		}
		return userRepository.findByUsernameAndPassword(loginRequest.getUsername(),
				passwordAES256.encrypt(loginRequest.getPassword()));
	}
    // You can add more service methods as needed
    
    
}

