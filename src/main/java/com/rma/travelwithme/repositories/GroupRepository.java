package com.rma.travelwithme.repositories;

import com.rma.travelwithme.models.Group;
import com.rma.travelwithme.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
	List<Group> findByGroupLeader(User user);
}

