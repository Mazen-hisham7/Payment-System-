package com.example.demo.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.RefundRequest;
import com.example.demo.Model.User;
import com.example.demo.Model.TransactionsModel.Transaction;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.AdminServiceImpl;


@RestController
public class AdminController {
	@Autowired
    AdminService adminService = new AdminServiceImpl();
	@PostMapping("/admin/signIn")
	public String signIn(String email, String password) {
		return adminService.signIn(email, password);
	}
	@GetMapping("/admin/getAllUsers")
	public ArrayList<User> getAllUsers() {
		return adminService.getAllUsers();
	}
	@GetMapping("/admin/getUserTransactions")
	public ArrayList<Transaction> getAllUserTransactions(int userID){
		return adminService.getAllUserTransactions(userID);
	}
	@GetMapping("/admin/getAllUserRefundRequests")
	public ArrayList<RefundRequest> getAllUserRefundRequests(int userID){
		return adminService.getAllUserRefundRequests(userID);
	}
	@PostMapping("/admin/addDiscount")
	public String addDiscount(String type, double value, String serviceName) {
		return adminService.addDiscount(type, value, serviceName);
	} 
	@PutMapping("/admin/acceptRefund")
	public String acceptRefund(String decision, int userID, int requestID){
		return adminService.acceptRefundRequest(decision, userID, requestID);
	}
}
