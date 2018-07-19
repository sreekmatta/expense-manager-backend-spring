package com.expensegator.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.expensegator.demo.models.Expense;

@Service
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

//	@Query("SELECT e FROM expense e, expense_payers ep, expense_people_involved eip "
//			+ "where ( e.id = ep.expense_id AND ep.payers_id = :id ) OR"
//			+ "( e.id = eip.expense_id AND eip.people_involved_id = :id )") 
//	List<Expense> findAllByPayersOrPeopleInvolved(@Param("id") int id);

}
