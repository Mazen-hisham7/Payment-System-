package com.example.demo.Model;

public class Admin {
	String userName; 
    String email; 
    String password;
    boolean loggedIn;
	public Admin(String userName, String email, String password){
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.loggedIn = false;
    }
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }

}
