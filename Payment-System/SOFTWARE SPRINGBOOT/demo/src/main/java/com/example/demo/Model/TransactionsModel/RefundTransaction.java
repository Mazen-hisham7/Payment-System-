package com.example.demo.Model.TransactionsModel;

public class RefundTransaction extends Transaction{
	boolean accepted;
	public RefundTransaction(String su, double a, int uID) {
		super(a, uID);
		this.type = "Refund Transaction";
		this.serviceUsed = su;
	}
}
