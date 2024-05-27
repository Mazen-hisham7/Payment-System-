package com.example.demo.Service;

import org.springframework.stereotype.Service;
import com.example.demo.Model.RefundRequest;
import com.example.demo.Model.User;
import com.example.demo.Model.DiscountsModel.OverallDiscount;
import com.example.demo.Model.DiscountsModel.SpecificDiscount;
import com.example.demo.Model.TransactionsModel.RefundTransaction;
import com.example.demo.Model.TransactionsModel.Transaction;

import static com.example.demo.DB.Database.*;

import java.util.ArrayList;

@Service
public class AdminServiceImpl implements AdminService{
	@Override
	public String signIn(String email, String password) {
		if(admin.isLoggedIn()) return "Admin is already logged in!";
		if(admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
			admin.setLoggedIn(true);
			return "Admin signed in sucessfully!";
		}
		return "Wrong credintials!";
	}
	@Override
	public ArrayList<User> getAllUsers() {
		return users;
	}
	public boolean checkAdmin() {
		if(admin.isLoggedIn()) return true;
		else return false;
	}
	@Override
	public ArrayList<RefundRequest> getAllUserRefundRequests(int userID) {
		User user = getUserByID(userID);
		return user.getRefunds();
	}
	@Override
	public User getUserByID(int userID) {
		for (User user : loggedInUsers) {
			if(user.getID() == userID)
				return user;
		}
		return null;
	}
	@Override
	public ArrayList<Transaction> getAllUserTransactions(int userID){
		User user = getUserByID(userID);
		return user.getTransactions();
	};
	@Override
	public String addDiscount(String type, double value, String sName) {
		if(!admin.isLoggedIn()) return "Admin is not logged in!";
		if(type.equals("specific") && (!sName.equals("Internet Payment") && !sName.equals("Mobile Recharge") && !sName.equals("Landline Service") && !sName.equals("Donation Service")))
			return "Service selected does not exist!";
		if(type.equals("overall")) {
			systemDiscounts.add(new OverallDiscount(value));
			return "An overall discount of a value of "+value+ "% has been added to the system sucessfully";
		}
		else if(type.equals("specific")) {
			systemDiscounts.add(new SpecificDiscount(value, sName));
			return "A specific discount of a value of "+value+ "% has been added to the "+ sName +" service sucessfully";
		}
		return "Discount type is invalid!";
	}
	@Override
	public String acceptRefundRequest(String decision, int userID, int requestID) {
		if(!admin.isLoggedIn()) return "Admin is not logged in!";
		if(!decision.equals("accept") && !decision.equals("decline")) return "Decision not clear!";
		User user = getUserByID(userID);
		if(user == null) return "User is not found!";
		RefundRequest desiredRefund = null;
		for (RefundRequest r : user.getRefunds()) {
			if(r.getId() == requestID)
				desiredRefund = r;
		}
		if(desiredRefund == null) return "Refund request is not found!";
		double refundedAmount;
		double userBalance;
		if(decision.equals("accept")) {
			refundedAmount = desiredRefund.getAmount();
			userBalance = user.getWalletBalance();
			user.setWalletBalance(refundedAmount + userBalance);
			user.getRefunds().remove(desiredRefund);
			user.getTransactions().add(new RefundTransaction(desiredRefund.getServiceUsed(), refundedAmount, userID));
			return "An amount of "+ refundedAmount + " EGP has been refunded to user "+ user.getUserName();
		}
		else {
			user.getRefunds().remove(desiredRefund);
			return "Refund request has been declined sucessfully";
		}
	}
	
}
