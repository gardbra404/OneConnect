package com.oneconnect.OneConnect.Test;

import org.springframework.web.servlet.ModelAndView;

import com.oneconnect.OneConnect.Landing.LandingService;

public class LandingTest {

	public boolean validAdmin() {
		
		String adminId = "123";
		String role = "admin";
		
		LandingService landingService = new LandingService();
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, adminId);

		if(modelAndView.getViewName().equals("ADMIN_LANDING")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean invalidAdmin() {
		
		String adminId = "999999";
		String role = "admin";
		
		LandingService landingService = new LandingService();
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, adminId);

		if(modelAndView.getViewName().equals("forbidden")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validTeacher() {
		
		String adminId = "125";
		String role = "teacher";
		
		LandingService landingService = new LandingService();
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, adminId);

		if(modelAndView.getViewName().equals("TEACHER_LANDING")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean invalidTeacher() {
		
		String teacherId = "999999";
		String role = "teacher";
		
		LandingService landingService = new LandingService();
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, teacherId);

		if(modelAndView.getViewName().equals("forbidden")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validStudent() {
		
		String studentId = "123";
		String role = "student";
		
		LandingService landingService = new LandingService();
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, studentId);

		if(modelAndView.getViewName().equals("STUDENT_LANDING")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean invalidStudent() {
		
		String studentId = "999999";
		String role = "student";

		LandingService landingService = new LandingService();
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, studentId);

		if(modelAndView.getViewName().equals("forbidden")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean validParent() {
		
		String parentId = "125";
		String role = "parent";
		
		LandingService landingService = new LandingService();
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, parentId);

		if(modelAndView.getViewName().equals("PARENT_LANDING")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean invalidParent() {
		
		String parentId = "999999";
		String role = "parent";

		LandingService landingService = new LandingService();
		
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, parentId);

		if(modelAndView.getViewName().equals("forbidden")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean nullUserId() {
		
		String userId = null;
		String role = "student";
	
		LandingService landingService = new LandingService();
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, userId);
	
		if(modelAndView.getViewName().equals("forbidden")) {
			return true;
		} else {
			return false;
		}
	
	}
	
	public boolean emptyUserId() {
		
		String userId = "";
		String role = "student";
		
		LandingService landingService = new LandingService();
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, userId);
	
		if(modelAndView.getViewName().equals("forbidden")) {
			return true;
		} else {
			return false;
		}
	}
	public boolean nonNumericUserId() {
		
		String userId = "thisisnotanumber";
		String role = "student";
		
		LandingService landingService = new LandingService();
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, userId);
	
		if(modelAndView.getViewName().equals("forbidden")) {
			return true;
		} else {
			return false;
		}
	}

	 public String runTests() {
	        return "<br/><br/>Landing Test:"
	                +"<br/>validAdmin: " + (validAdmin() ? "Passed" : "Failed")
	                +"<br/>invalidAdmin: " + (invalidAdmin() ? "Passed" : "Failed")
	                +"<br/>validTeacher: " + (validTeacher() ? "Passed" : "Failed")
	                +"<br/>invalidTeacher: " + (invalidTeacher() ? "Passed" : "Failed")
	                +"<br/>validStudent: " + (validStudent() ? "Passed" : "Failed")
	                +"<br/>invalidStudent: " + (invalidStudent() ? "Passed" : "Failed")
	                +"<br/>validParent: " + (validParent() ? "Passed" : "Failed")
	                +"<br/>invalidParent: " + (invalidParent() ? "Passed" : "Failed")
	                +"<br/>nullUserId: " + (nullUserId() ? "Passed" : "Failed")
	                +"<br/>emptyUserId: " + (emptyUserId() ? "Passed" : "Failed")
	                +"<br/>nonNumericUserId: " + (nonNumericUserId() ? "Passed" : "Failed");

	    }
	
}
