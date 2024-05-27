package com.example.demo.Model.DiscountsModel;

public abstract class Discount {
	String type;
	double value;
	String service = "";
	boolean used;
	public Discount(double value) {
		this.value = value;
		this.used = false;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	public String getType() {
		return type;
	}
	public double getValue() {
		return value;
	}
	public String getService() {
		return service;
	}
}
