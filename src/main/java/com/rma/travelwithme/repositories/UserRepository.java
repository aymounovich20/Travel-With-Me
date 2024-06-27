package com.rma.travelwithme.repositories;

import com.rma.travelwithme.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByUserId(Long id);
	User findByUsernameAndPassword(String username,String password);
    // You can add custom query methods if needed

}

