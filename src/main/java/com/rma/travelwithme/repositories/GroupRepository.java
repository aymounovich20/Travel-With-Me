package com.rma.travelwithme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rma.travelwithme.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    // You can add custom query methods if needed
}

