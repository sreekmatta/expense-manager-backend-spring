package com.expensegator.demo.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.expensegator.demo.types.ExpenseType;

@Table(name="expense")  
@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ename;
	private ExpenseType expenseType;

	@ManyToMany
    @JoinColumn(name = "id")
	private Collection<User> payers;

	@ManyToMany
    @JoinColumn(name = "id")
	private Collection<User> peopleInvolved;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;

	@OneToOne
    @JoinColumn(name = "id")
	private Group group;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public ExpenseType getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(ExpenseType expenseType) {
		this.expenseType = expenseType;
	}

	public Collection<User> getPayers() {
		return payers;
	}

	public void setPayers(Collection<User> payers) {
		this.payers = payers;
	}

	public Collection<User> getPeopleInvolved() {
		return peopleInvolved;
	}

	public void setPeopleInvolved(Collection<User> peopleInvolved) {
		this.peopleInvolved = peopleInvolved;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
