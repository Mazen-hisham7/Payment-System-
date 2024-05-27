package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Model.TransactionsModel.Transaction;

public interface Payment {
	public abstract Transaction pay(User user, double amount, String su);
	public abstract double applyDiscount(double amount, String su);
}
