package com.example.demo.DB;

import java.util.ArrayList;

import com.example.demo.Model.Admin;
import com.example.demo.Model.User;
import com.example.demo.Model.DiscountsModel.Discount;

public class Database {
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<User> loggedInUsers = new ArrayList<User>();
	public static ArrayList<Discount> systemDiscounts = new ArrayList<Discount>();
	public static Admin admin = new Admin("admin", "admin", "123");
}
