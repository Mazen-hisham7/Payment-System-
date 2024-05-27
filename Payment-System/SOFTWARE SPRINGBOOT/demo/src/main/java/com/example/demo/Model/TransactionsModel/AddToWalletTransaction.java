package com.example.demo.Model.TransactionsModel;

public class AddToWalletTransaction extends Transaction{
	public AddToWalletTransaction(double a, int uID) {
		super(a, uID);
		this.type = "Add to Wallet Transaction";
	}
}
