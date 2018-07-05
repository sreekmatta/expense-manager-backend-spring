package com.expensegator.demo.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Table(name="expense_group")  
@Entity
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int groupname;
	
	@OneToMany
    @JoinColumn(name = "id")
	private Collection<User> members;
	
	@OneToOne
	@JoinColumn(name = "id")
	private User createdByUser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@OneToMany
	@JoinColumn(name = "id")
	private Collection<Expense> expenses;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroupname() {
		return groupname;
	}

	public void setGroupname(int groupname) {
		this.groupname = groupname;
	}

	public Collection<User> getMembers() {
		return members;
	}



	public Collection<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Collection<Expense> expenses) {
		this.expenses = expenses;
	}

	public void setMembers(Collection<User> members) {
		this.members = members;
	}

	public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
