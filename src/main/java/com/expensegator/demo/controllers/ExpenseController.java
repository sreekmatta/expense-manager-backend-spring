package com.expensegator.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.expensegator.demo.models.Expense;
import com.expensegator.demo.models.User;
import com.expensegator.demo.repositories.ExpenseRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExpenseController {
	@Autowired
	ExpenseRepository expenseRepository;

	public void createExpense() {

	}

	@GetMapping("/api/expense/{id}")
	public Optional<Expense> getExpenseByID(@PathVariable("id") int id) {
		return expenseRepository.findById(id);
	}

	@GetMapping("/api/people/expense/by/{id}")
	public List<Expense> findAllExpensesByPayersOrPeopleInvolved(@PathVariable("id") int id) {
		List<Expense> allExpenses = expenseRepository.findAll();
		List<Expense> expensesByPayersOrPeopleInvolved = new ArrayList<>();
		
		for (Expense currExpense : allExpenses) {
			if (!currExpense.getPayers().isEmpty() || !currExpense.getPeopleInvolved().isEmpty()) {
				if (!currExpense.getPayers().isEmpty()) {
					for (User u : currExpense.getPayers()) {
						if (u.getId() == id) {
							expensesByPayersOrPeopleInvolved.add(currExpense);
							break;
						}
					}
					continue;
				}
				if (!currExpense.getPeopleInvolved().isEmpty()) {
					for (User u : currExpense.getPeopleInvolved()) {
						if (u.getId() == id) {
							expensesByPayersOrPeopleInvolved.add(currExpense);
							break;
						}
					}
					continue;
				}

			}

		}
		return expensesByPayersOrPeopleInvolved;
	}

	@GetMapping("/api/expense")
	public List<Expense> findAllExpenses() {
		return expenseRepository.findAll();
	}

	public void updateExpense() {

	}

	public void deleteExpense() {

	}

}
