package com.rma.travelwithme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rma.travelwithme.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // You can add custom query methods if needed
}

