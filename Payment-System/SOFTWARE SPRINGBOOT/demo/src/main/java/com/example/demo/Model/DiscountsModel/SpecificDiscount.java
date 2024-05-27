package com.example.demo.Model.DiscountsModel;

public class SpecificDiscount extends Discount{
	public SpecificDiscount(double value, String service) {
		super(value);
		this.type = "Specific discount";
		this.service = service;
	}
}
