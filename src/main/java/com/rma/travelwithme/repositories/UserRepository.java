package com.rma.travelwithme.repositories;

import com.rma.travelwithme.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

