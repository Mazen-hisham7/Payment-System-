package com.example.demo.Service;
import java.util.ArrayList;
import com.example.demo.Model.RefundRequest;
import com.example.demo.Model.User;
import com.example.demo.Model.TransactionsModel.Transaction;
public interface AdminService {
	public String signIn(String email, String password);
	public ArrayList<User> getAllUsers();
	public ArrayList<Transaction> getAllUserTransactions(int userID);
	public User getUserByID(int userID);
	public ArrayList<RefundRequest> getAllUserRefundRequests(int userID);
	public String addDiscount(String type, double value, String sName);
	public String acceptRefundRequest(String decision, int userID, int requestID);
}
