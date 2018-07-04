package com.expensegator.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.expensegator.demo.models.Expense;

@Service
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

}
