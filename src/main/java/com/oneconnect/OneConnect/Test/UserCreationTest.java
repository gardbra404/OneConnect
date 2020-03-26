package com.oneconnect.OneConnect.Test;

import com.oneconnect.OneConnect.UserCreation.UserCreationService;

public class UserCreationTest {

	public boolean ValidAccount() {

		String name = "Noah Dabrowski";
		List<String> role = Arrays.asList("admin");
		String userId = "qwertyuiop";
		List<String> classes = new ArrayList<String>();
		List<Child> children = new ArrayList<Child>();

		UserCreationService userCreationService = new UserCreationService();
		
		 if (userCreationService.createUser(name, role, userId, classes, children) != null)
			return true; 
		
		return false;
	}
	
	public boolean InvalidPassword(){
		
		String name = "Noah";
		List<String> role = Arrays.asList("admin");
		String userId = "qwertyuiop";
		List<String> classes = new ArrayList<String>();
		List<Child> children = new ArrayList<Child>();
		
		UserCreationService userCreationService = new UserCreationService();
		
		 if (userCreationService.createUser(name, role, userId, classes, children) == null)
			return true; 
		
		return false;
	}
	
	public boolean UserExists(){
		String name = "Noah";
		List<String> role = Arrays.asList("admin");
		String userId = "qwertyuiop";
		List<String> classes = new ArrayList<String>();
		List<Child> children = new ArrayList<Child>();
		
		UserCreationService userCreationService = new UserCreationService();
		
		userCreationService.createUser(name, role, userId, classes, children); //create the user

		//try to create the user again
		 if (userCreationService.createUser(name, role, userId, classes, children) == null)
			return true; 
		
		return false;		
	}
	
	public boolean InvalidRole(){
		String name = "Noah";
		List<String> role = Arrays.asList("guh");
		String userId = "qwertyuiop";
		List<String> classes = new ArrayList<String>();
		List<Child> children = new ArrayList<Child>();
		
		UserCreationService userCreationService = new UserCreationService();
		
		 if (userCreationService.createUser(name, role, userId, classes, children) == null)
			return true; 
		
		return false;
	}
	
	public boolean nullUserId(){
		String name = "Noah";
		List<String> role = Arrays.asList("admin");
		String userId = null;
		List<String> classes = new ArrayList<String>();
		List<Child> children = new ArrayList<Child>();
		
		UserCreationService userCreationService = new UserCreationService();
		
		 if (userCreationService.createUser(name, role, userId, classes, children) == null)
			return true; 
		
		return false;
		
	}
	
	public boolean InvalidFullName(){
		
		String name = "Noah";
		List<String> role = Arrays.asList("admin");
		String userId = "qwertyuiop";
		List<String> classes = new ArrayList<String>();
		List<Child> children = new ArrayList<Child>();
		
		UserCreationService userCreationService = new UserCreationService();
		
		 if (userCreationService.createUser(name, role, userId, classes, children) == null)
			return true; 
		
		return false;
	}
	
	public String runTests() {
	        return "<br/><br/>Assignment Test:"
	                +"<br/>ValidAccount: " + (ValidAccount() ? "Passed" : "Failed")
	                +"<br/>InvalidPassword: " + (InvalidPassword() ? "Passed" : "Failed")
	                +"<br/>UserExists: " + (UserExists() ? "Passed" : "Failed")
	                +"<br/>InvalidRole: " + (InvalidRole() ? "Passed" : "Failed")
					+"<br/>nullUserId: " + (nullUserId() ? "Passed" : "Failed")
					+"<br/>InvalidFullName: " + (InvalidFullName() ? "Passed" : "Failed");

	}
	
}