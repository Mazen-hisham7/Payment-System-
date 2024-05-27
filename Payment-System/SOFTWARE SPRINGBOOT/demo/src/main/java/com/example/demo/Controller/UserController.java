package com.example.demo.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.DiscountsModel.Discount;
import com.example.demo.Model.TransactionsModel.Transaction;
import com.example.demo.Service.UserService;
import com.example.demo.Service.UserServiceImpl;

@RestController
public class UserController {
	@Autowired
    UserService userService = new UserServiceImpl();
	@PostMapping("/user/signIn")
	public String signIn(String email, String password) { 
		return userService.signIn(email, password);
	}
	@PostMapping("/user/signUp")
	public String signUp(String userName , String email, String password) { 
		return userService.signUp(userName, email, password);
	}
	@PutMapping("/user/addFundsToWallet")
	public String addFundsToWallet(int userID, double amount) {
		return userService.addFundsToWallet(userID, amount);
	}
	@GetMapping("/user/search")
	public String search(String query) {
		return userService.search(query);
	}
	@GetMapping("/user/getAllPurchases")
	public ArrayList<Transaction> getAllPurchases(int userID){
		return userService.getAllPurchases(userID);
	}
	@PostMapping("/user/payForService")
	public String useService(int userID, int serviceID , int providerID, int paymentMethodID, double amount, String mobileNumber){
		return userService.useService(userID, serviceID, providerID, paymentMethodID, amount);
	}
	@PostMapping("/user/requestRefund")
	public String requestRefund(int userID, int purchaseID) {
		return userService.requestRefund(userID, purchaseID);
	}
	@GetMapping("/user/checkDiscounts")
	public ArrayList<Discount> checkDiscounts(){
		return userService.checkDiscounts();
	}
}
