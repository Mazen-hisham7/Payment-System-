package com.example.demo.Service;

import com.example.demo.Model.ServicesModel.Donation;
import com.example.demo.Model.ServicesModel.InternetPayment;
import com.example.demo.Model.ServicesModel.LandLine;
import com.example.demo.Model.ServicesModel.MobileRecharge;
import com.example.demo.Model.ServicesModel.SystemService;
public class ServiceFactory {
	public static SystemService createService(int serviceID) {
		if  (serviceID != 1 && serviceID != 2 && serviceID != 3 && serviceID != 4) {
			return null;
		}
		else if(serviceID == 1) {
			return new InternetPayment();
		}
		else if(serviceID == 2) {
			return new MobileRecharge();
		}
		else if(serviceID == 3) {
			return new LandLine();
		}
		else if(serviceID == 4) {
			return new Donation();
		}
		return null;
	}
}
