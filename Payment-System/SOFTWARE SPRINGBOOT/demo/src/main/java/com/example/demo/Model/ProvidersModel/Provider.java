package com.example.demo.Model.ProvidersModel;



public abstract class Provider {
	String name;
	String mobileNumber;
	int ID;
	double amount;
	boolean cash, wallet, cc;
	public Provider() {
		this.cash = true;
		this.wallet = true;
		this.cc = true;
	}
	public String getName() { 
		return this.name;
	}
	public double getAmountToBePaid() { 
		return this.amount;
	}
	public int getID() {
		return this.ID;
	}
}
