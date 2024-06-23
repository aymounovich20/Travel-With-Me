package com.rma.travelwithme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rma.travelwithme.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods if needed
}

