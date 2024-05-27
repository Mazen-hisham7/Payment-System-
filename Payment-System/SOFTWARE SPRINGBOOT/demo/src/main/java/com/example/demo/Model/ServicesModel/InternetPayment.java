package com.example.demo.Model.ServicesModel;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.Model.ProvidersModel.Etisalat;
import com.example.demo.Model.ProvidersModel.Orange;
import com.example.demo.Model.ProvidersModel.Provider;
import com.example.demo.Model.ProvidersModel.Vodafone;
import com.example.demo.Model.ProvidersModel.We;
@Service
public class InternetPayment extends SystemService{
	public InternetPayment (){
		this.setProviders(new ArrayList<Provider>());
		this.setName("Internet Payment");
		Provider Vodafone = new Vodafone();
		Provider Etisalat = new Etisalat();
		Provider Orange = new Orange();
		Provider We = new We();
		this.addProvider(Vodafone);
		this.addProvider(Etisalat);
		this.addProvider(Orange);
		this.addProvider(We);
	}
}
