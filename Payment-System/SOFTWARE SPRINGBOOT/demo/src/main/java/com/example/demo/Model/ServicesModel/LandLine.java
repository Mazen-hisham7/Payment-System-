package com.example.demo.Model.ServicesModel;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.Model.ProvidersModel.Monthly;
import com.example.demo.Model.ProvidersModel.Provider;
import com.example.demo.Model.ProvidersModel.Quarterly;
@Service
public class LandLine extends SystemService{
	public LandLine () {
		this.setProviders(new ArrayList<Provider>());
		this.setName("LandLine Service");
		Provider Monthly = new Monthly();
		Provider Quarterly = new Quarterly();
		this.addProvider(Monthly);
		this.addProvider(Quarterly);
	}

}
