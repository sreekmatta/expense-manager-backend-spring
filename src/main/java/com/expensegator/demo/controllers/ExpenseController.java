package com.expensegator.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.expensegator.demo.repositories.ExpenseRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExpenseController {
	@Autowired
	ExpenseRepository expenseRepository;
	
	public void createExpense() {
		
	}
	
	public void getExpenseByID() {
		
	}
	
	public void updateExpense() {
		
	}
	
	public void deleteExpense() {
		
	}

}
