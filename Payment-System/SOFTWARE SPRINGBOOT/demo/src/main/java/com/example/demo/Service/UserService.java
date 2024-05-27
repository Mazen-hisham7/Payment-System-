package com.example.demo.Service;

import java.util.ArrayList;

import com.example.demo.Model.User;
import com.example.demo.Model.DiscountsModel.Discount;
import com.example.demo.Model.TransactionsModel.Transaction;

public interface UserService {
	public User getUserByID(int userID);
	public ArrayList<Transaction> getAllPurchases(int userID);
 	public String signIn(String email, String password);
	public String signUp(String userName, String email, String pass);
	public Transaction payByWallet(User user, double amount, String su);
	public Transaction payByCC(User user, double amount, String su);
	public Transaction payByCash(User user, double amount, String su);
	public String useService(int userID , int serviceID , int providerID, int paymentMethodID, double amount);
	public String addFundsToWallet(int userID, double amount);
	public String search(String query);
	public String requestRefund(int userID, int paymentID);
	public ArrayList<Discount> checkDiscounts();
}
