package com.example.demo.Model.ServicesModel;


import com.example.demo.Model.ProvidersModel.CancerHospital;
import com.example.demo.Model.ProvidersModel.NGOs;
import com.example.demo.Model.ProvidersModel.Provider;
import com.example.demo.Model.ProvidersModel.Schools;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
@Service
public class Donation extends SystemService{
	public Donation () {
		this.setProviders(new ArrayList<Provider>());
		this.setName("Donation Service");
		Provider NGOs = new NGOs();
		Provider CancerHospital = new CancerHospital();
		Provider Schools = new Schools();
		this.addProvider(NGOs);
		this.addProvider(CancerHospital);
		this.addProvider(Schools);
	}
}
