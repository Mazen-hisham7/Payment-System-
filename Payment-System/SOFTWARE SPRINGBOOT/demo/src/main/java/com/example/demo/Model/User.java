package com.example.demo.Model;

import java.util.ArrayList;
import com.example.demo.Model.TransactionsModel.Transaction;

public class User {
	String userName; 
    String email; 
    String password;
    Double wallet;
    String mobileNumber;
    private static int currentUserID = 0;
    int id;
    // an array to store all the user purchases
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    ArrayList<RefundRequest> refunds = new ArrayList<RefundRequest>();
    public User(String userName, String email, String password){
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.wallet = 100d;
        currentUserID++;
        this.id = currentUserID;
        this.mobileNumber = "0101010001" + currentUserID;
    }
	public User() {
    }
    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
    public Double getWalletBalance(){
        return this.wallet;
    }
    public int getID() {
    	return id;
    }
    public void setWalletBalance(double amount){
    	this.wallet = amount;
    }
    public void addRefundRequest(RefundRequest r) {
    	refunds.add(r);
    }
    public ArrayList<Transaction> getTransactions(){
        return this.transactions;
    }
    public ArrayList<RefundRequest> getRefunds() {
		return refunds;
	}
    public String getPhoneNumber() {
    	return mobileNumber;
    }
    @Override
	public String toString() {
		return email + "::" + userName + "::";
	}
}
