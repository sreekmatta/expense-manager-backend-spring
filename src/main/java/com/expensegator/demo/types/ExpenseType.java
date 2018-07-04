package com.expensegator.demo.types;

public enum ExpenseType {

	FOOD("Food"), TRANSPORT("Transport"), TRAVEL("Travel"), ENTERTAINMENT("Entertainment");

	private String ename;

	public String getType() {
		return ename;
	}

	private ExpenseType(String ename) {
		this.ename = ename;
	}
}
