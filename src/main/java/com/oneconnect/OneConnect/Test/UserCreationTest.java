package com.oneconnect.OneConnect.Test;

public class UserCreationTest{
	
	public boolean ValidAccount(){
		
		String userId = "qwertyuiop";
		String userEmail = "guil9416@kettering.edu";
		String fullName = "Austin Guilbault";
		String role = "admin";
		String password = "123ABCqwe?!";
		/*
		UserService userService = new userService();
		
		if (userService.createUser(userId, userEmail, fullName, role, password) != null)
			return true;
		*/
		return false;
	}
	
	public boolean InvalidPassword(){
		
		String userId = "qwertyuiop";
		String userEmail = "guil9416@kettering.edu";
		String fullName = "Austin Guilbault";
		String role = "admin";
		String password = "bob";
		/*
		UserService userService = new userService();
		
		if (userService.createUser(userId, userEmail, fullName, role, password) == null)
			return true;
		*/
		return false;
	}
	
	public boolean UserExists(){
		String userId = "qwertyuiop";
		String userEmail = "guil9416@kettering.edu";
		String fullName = "Austin Guilbault";
		String role = "admin";
		String password = "123ABCqwe?!";
		/*
		UserService userService = new userService();
		
		userService.createUser(userId, userEmail, fullName, role, password) //create the user
		
		//try to create the user again
		if (userService.createUser(userId, userEmail, fullName, role, password) == null)
			return true;
		*/
		return false;		
	}
	
	public boolean InvalidRole(){
		String userId = "qwertyuiop";
		String userEmail = "guil9416@kettering.edu";
		String fullName = "Austin Guilbault";
		String role = ":^)";
		String password = "123ABCqwe?!";
		/*
		UserService userService = new userService();
		
		if (userService.createUser(userId, userEmail, fullName, role, password) == null)
			return true;
		*/
		return false;
	}
	
	public boolean nullUserId(){
		String userId = null;
		String userEmail = "guil9416@kettering.edu";
		String fullName = "Austin Guilbault";
		String role = ":^)";
		String password = "123ABCqwe?!";
		/*
		UserService userService = new userService();
		
		if (userService.createUser(userId, userEmail, fullName, role, password) == null)
			return true;
		*/
		return false;
		
	}
	
	public boolean InvalidEmail(){
		String userId = "blahblah";
		String userEmail = "noatsign";
		String fullName = "Austin Guilbault";
		String role = "student";
		String password = "123ABCqwe?!";
		/*
		UserService userService = new userService();
		
		if (userService.createUser(userId, userEmail, fullName, role, password) == null)
			return true;
		*/
		return false;
		
	}
	
	public boolean InvalidFullName(){
		
		String userId = "qwertyuiop";
		String userEmail = "guil9416@kettering.edu";
		String fullName = "onlyoneword";
		String role = "admin";
		String password = "123ABCqwe?!";
		/*
		UserService userService = new userService();
		
		if (userService.createUser(userId, userEmail, fullName, role, password) == null)
			return true;
		*/
		return false;
	}
	
	public String runTests() {
	        return "<br/><br/>Assignment Test:"
	                +"<br/>ValidAccount: " + (ValidAccount() ? "Passed" : "Failed")
	                +"<br/>InvalidPassword: " + (InvalidPassword() ? "Passed" : "Failed")
	                +"<br/>UserExists: " + (UserExists() ? "Passed" : "Failed")
	                +"<br/>InvalidRole: " + (InvalidRole() ? "Passed" : "Failed")
					+"<br/>nullUserId: " + (nullUserId() ? "Passed" : "Failed")
					+"<br/>InvalidEmail: " + (InvalidEmail() ? "Passed" : "Failed")
					+"<br/>InvalidFullName: " + (InvalidFullName() ? "Passed" : "Failed");

	}
	
}