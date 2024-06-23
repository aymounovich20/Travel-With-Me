package com.rma.travelwithme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rma.travelwithme.models.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // You can add custom query methods if needed
}

