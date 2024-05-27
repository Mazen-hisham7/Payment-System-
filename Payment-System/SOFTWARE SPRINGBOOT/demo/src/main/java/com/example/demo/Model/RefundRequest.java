package com.example.demo.Model;

public class RefundRequest {
	double amount;
	int userID;
	boolean accepted;
	int id = 0;
	String service;
	private static int counter = 0 ;
	public RefundRequest(double amount, int userID, String service) {
		this.amount = amount;
		this.userID = userID;
		counter++;
		this.id = counter;
		this.service = service;
	}
	public int getId() {
		return id;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public double getAmount() {
		return amount;
	}
	public int getUserID() {
		return userID;
	}
	public String getServiceUsed() {
		return service;
	}

}
