package com.rma.travelwithme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rma.travelwithme.models.Expense;
import com.rma.travelwithme.repositories.ExpenseRepository;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Service methods to interact with ExpenseRepository
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // You can add more service methods as needed
}

