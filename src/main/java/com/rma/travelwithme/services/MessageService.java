package com.rma.travelwithme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rma.travelwithme.models.Message;
import com.rma.travelwithme.repositories.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // Service methods to interact with MessageRepository
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // You can add more service methods as needed
}

