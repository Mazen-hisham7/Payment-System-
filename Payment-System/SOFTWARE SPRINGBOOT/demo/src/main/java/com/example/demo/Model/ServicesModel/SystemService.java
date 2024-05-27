package com.example.demo.Model.ServicesModel;

import java.util.ArrayList;

import com.example.demo.Model.ProvidersModel.Provider;

public abstract class SystemService {
	private String name;
	private ArrayList<Provider> providers;
	private double discount;
	public double getDiscount() {
		return this.discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public ArrayList<Provider> getProviders() {
		return this.providers;
	}
	public void addProvider(Provider provider) {
		providers.add(provider);
	}
	public void setProviders(ArrayList<Provider> providers) {
		this.providers = providers;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
