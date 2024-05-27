package com.example.demo.Model.ServicesModel;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.Model.ProvidersModel.Etisalat;
import com.example.demo.Model.ProvidersModel.Orange;
import com.example.demo.Model.ProvidersModel.Provider;
import com.example.demo.Model.ProvidersModel.Vodafone;
import com.example.demo.Model.ProvidersModel.We;
@Service
public class MobileRecharge extends SystemService{
	public MobileRecharge () {
		this.setProviders(new ArrayList<Provider>());
		this.setName("Mobile Recharge");
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
