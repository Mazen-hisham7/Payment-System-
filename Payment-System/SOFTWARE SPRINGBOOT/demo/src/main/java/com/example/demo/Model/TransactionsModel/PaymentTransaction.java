package com.example.demo.Model.TransactionsModel;

public class PaymentTransaction extends Transaction{
	boolean requestedArefund;
	public PaymentTransaction(String su, double a, int uID) {
		super(a, uID);
		this.type = "Payment Transaction";
		this.serviceUsed = su;
		this.requestedArefund = false;
	}
	
	public boolean isRequestedArefund() {
		return requestedArefund;
	}
	public void setRequestedArefund(boolean requestedArefund) {
		this.requestedArefund = requestedArefund;
	}
}
