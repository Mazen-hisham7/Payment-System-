package com.example.demo.Model.TransactionsModel;


public abstract class Transaction {
	double amount;
	int userID;
	String type;
	String serviceUsed;
	int transactionID;
	private static int counter = 0;
	public Transaction(double a, int uID){
		this.amount = a;
		this.userID = uID;
		counter++;
		this.transactionID = counter;
	}
	public double getAmount() {
		return amount;
	}
	public int getUserID() {
		return userID;
	}
	public String getType() {
		return type;
	}
	public String getServiceUsed() {
		return serviceUsed;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setType(String type) {
		this.type = type;
	}
}
