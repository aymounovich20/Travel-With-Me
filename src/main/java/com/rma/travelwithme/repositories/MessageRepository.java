package com.rma.travelwithme.repositories;

import com.rma.travelwithme.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}

