package com.rma.travelwithme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rma.travelwithme.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	User findByUsernameAndPassword(String username,String password);
    // You can add custom query methods if needed
}

