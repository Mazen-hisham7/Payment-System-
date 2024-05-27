package com.example.demo.Model.DiscountsModel;

public class OverallDiscount extends Discount{
	public OverallDiscount(double value) {
		super(value);
		this.type = "Overall discount";
	}
}
