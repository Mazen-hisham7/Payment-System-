package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Model.RefundRequest;
import com.example.demo.Model.User;
import com.example.demo.Model.DiscountsModel.Discount;
import com.example.demo.Model.ProvidersModel.Provider;
import com.example.demo.Model.ServicesModel.SystemService;
import com.example.demo.Model.TransactionsModel.AddToWalletTransaction;
import com.example.demo.Model.TransactionsModel.PaymentTransaction;
import com.example.demo.Model.TransactionsModel.Transaction;

import static com.example.demo.DB.Database.*;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService{
	static {
		User u1 = new User("user", "user", "123");
		users.add(u1);
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
	public ArrayList<Transaction> getAllPurchases(int userID){
		User activeUser = getUserByID(userID);
		ArrayList<Transaction> t = new ArrayList<Transaction>();
		for (Transaction trans : activeUser.getTransactions()) {
			if(trans.getType().equals("Payment Transaction")) {
				t.add(trans);
			}
		}
		return t;
	}
	@Override
	public String signIn(String email, String password) {
		User activeUser = null;
		for (User user : users) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				activeUser = user;
				break;
			}
		}
		if(activeUser == null) return "Wrong Credintials!";
		for (User user : loggedInUsers) {
			if(user == activeUser)
				return "User already logged in!";
		}
		loggedInUsers.add(activeUser);
		return "Signed in (User) sucessfully";
	}
	@Override
	public String signUp(String userName, String email, String pass) {
		for(User user : users) {
			if(user.getUserName().equals(userName))
				return "User name entered is already registered in the system!";
			if(user.getEmail().equals(email))
				return "Email entered is already registered in the system!";
		}
		users.add(new User(userName, email, pass));
		return "Sign up sucessful!" + "\nYou can now sign in using your entered credintials.";	
	}
	@Override
	public String addFundsToWallet(int userID, double amount) {
		User activeUser = null;
		for (User user : loggedInUsers) {
			if(user.getID() == userID)
				activeUser = user;
		}
		if(activeUser == null) return "User not found!";
		double wallet = activeUser.getWalletBalance() + amount;
		activeUser.setWalletBalance(wallet);
		activeUser.getTransactions().add(new AddToWalletTransaction(amount, userID));
		return amount + " EGP has been added sucessfully to your wallet balance!" + "\nYour new wallet balance is: " +activeUser.getWalletBalance()+" EGP";
	}
	@Override
	public String search(String query) {
		ArrayList<String> services = new ArrayList<String>();
		services.add("internet payment service");
		services.add("mobile recharge service");
		services.add("landline service");
		services.add("donation service");
		String matches = "";
		for (String service : services) {
			if(service.contains(query))
				matches += service + "\n";
		}
		if(matches == "") return "No serivce found that matches the entered query!";
		return matches;	
	}
	@Override
	public Transaction payByWallet(User user, double amount, String su) {
		Payment p = new PayByWallet();
		Transaction t = p.pay(user, amount, su);
		return t;
	}
	@Override
	public Transaction payByCC(User user, double amount, String su){
		Payment p = new PayByCC();
		Transaction t = p.pay(user, amount, su);
		return t;
	}
	@Override
	public Transaction payByCash(User user, double amount, String su){
		Payment p = new PayByCash();
		Transaction t = p.pay(user, amount, su);
		return t;
	}
	@Override
	public String requestRefund(int userID, int purchaseID) {
		User activeUser = getUserByID(userID);
		if(activeUser == null) return "User not found!";
		PaymentTransaction purchase = null;
		for (Transaction t : activeUser.getTransactions()) {
			if(t.getTransactionID() == purchaseID)
				purchase = (PaymentTransaction)t;
		}
		if(purchase == null) return "Purchase selected could not be found!";
		if(!purchase.getType().equals("Payment Transaction")) return "Purchase selected could not be found!";
		if(purchase.isRequestedArefund()) return "You have already requested a refund on this purchase!";
		activeUser.addRefundRequest(new RefundRequest(purchase.getAmount(), userID, purchase.getServiceUsed()));
		purchase.setRequestedArefund(true);
		return "Refund request of an amount = " + purchase.getAmount() + " EGP has been submitted sucessfully!";
	}
	@Override
	public String useService(int userID, int serviceID , int providerID, int paymentMethodID, double amount) {
		User activeUser = getUserByID(userID);
		if(activeUser == null) return "User not found!";
		SystemService service = ServiceFactory.createService(serviceID);
		if(service == null) return "The choosen service does not exist!";
		String choosenProvider = "";
		for (Provider p : service.getProviders()) {
			if(p.getID() == providerID)
				choosenProvider = p.getName();
		}
		if(choosenProvider.equals("")) return "The choosen service provider does not exist!";
		if (paymentMethodID != 1 && paymentMethodID != 2 && paymentMethodID != 3) return "Payment Method does not exist";
		Transaction t = null;
		if(paymentMethodID == 1) t = payByWallet(activeUser, amount, service.getName());
		else if(paymentMethodID == 2) t = payByCC(activeUser, amount, service.getName());
		else if(paymentMethodID == 3) t = payByCash(activeUser, amount, service.getName());
		if(t == null) 
			return "Payment Failed insufficient funds!";	
		return "Payment sucessful for "+ choosenProvider +" "+t.getServiceUsed() +"\nAmount paid: "+ t.getAmount() + " EGP";
	}
	@Override
	public ArrayList<Discount> checkDiscounts(){
		return systemDiscounts;
	};
}
