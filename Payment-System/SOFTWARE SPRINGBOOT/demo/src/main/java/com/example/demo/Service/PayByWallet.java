package com.example.demo.Service;

import static com.example.demo.DB.Database.systemDiscounts;

import com.example.demo.Model.User;
import com.example.demo.Model.DiscountsModel.Discount;
import com.example.demo.Model.TransactionsModel.PaymentTransaction;
import com.example.demo.Model.TransactionsModel.Transaction;

public class PayByWallet implements Payment {
	@Override
	public double applyDiscount(double amount, String su) {
		double amountAfterDiscount = 0;
		if(systemDiscounts.isEmpty()) return amount;
		for (Discount discount : systemDiscounts) {
			if(discount.getType().equals("Overall discount") && !discount.isUsed()) {
				amountAfterDiscount += discount.getValue();
				discount.setUsed(true);
			}
			if(discount.getType().equals("Specific discount") && discount.getService().equals(su) && !discount.isUsed()) {
				amountAfterDiscount += discount.getValue();
				discount.setUsed(true);
			}
		}
		amountAfterDiscount = amount - ((amountAfterDiscount * amount)/100);
		return amountAfterDiscount;
	}
	public void removeUsedDiscounts() {
		int numberOfDiscounts =  systemDiscounts.size();
		for(int i =0 ; i< numberOfDiscounts ; i++) {
			for (Discount discount : systemDiscounts) {
				if(discount.isUsed()) {
					systemDiscounts.remove(discount);
					break;
				}
			}
		}
	}
	@Override
	public Transaction pay(User user, double amount, String su) {
		double amountAfterDiscount = applyDiscount(amount, su);
		if (user.getWalletBalance() >= amountAfterDiscount) {
			double wallet = user.getWalletBalance() - amountAfterDiscount;
			user.setWalletBalance(wallet);
			PaymentTransaction p = new PaymentTransaction(su, amountAfterDiscount, user.getID());
			user.getTransactions().add(p);
			removeUsedDiscounts();
			return p;
		}
		else return null;
	}
}
