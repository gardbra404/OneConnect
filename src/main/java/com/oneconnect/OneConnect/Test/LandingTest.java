package com.oneconnect.OneConnect.Test;

import org.springframework.web.servlet.ModelAndView;

import com.oneconnect.OneConnect.Landing.LandingService;

public class LandingTest {

	public boolean validAdmin() {
		
		String adminId = "23";
		
//		LandingService landingService = newLandingService();
//		LandingPageDto landingPageDto = landingService.retrieveLandingPageData(adminId);
//		
//		if(landingPageDto.type = PageType.ADMIN) {
//			return true;
//		} else {
//			return false;
//		}
//		
		
		return false;
	}
	
	public boolean invalidAdmin() {
		
		String adminId = "thisadmindoesntexist";
		
//		LandingService landingService = newLandingService();
//		LandingPageDto landingPageDto = landingService.retrieveLandingPageData(adminId);
//		
//		if(landingPageDto == null) {
//			return true;
//		} else {
//			return false;
//		}
//		
		
		return false;
	}
	
	public boolean validTeacher() {
		
		String teacherId = "115";
		
//		LandingService landingService = newLandingService();
//		LandingPageDto landingPageDto = landingService.retrieveLandingPageData(teacherId);
//		
//		if(landingPageDto.type = PageType.TEACHER) {
//			return true;
//		} else {
//			return false;
//		}
		
		return false;
	}
	
	public boolean invalidTeacher() {
		
		String teacherId = "thisteacherdoesnotexist";
		
//		LandingService landingService = newLandingService();
//		LandingPageDto landingPageDto = landingService.retrieveLandingPageData(teacherId);
//		
//		if(landingPageDto == null) {
//			return true;
//		} else {
//			return false;
//		}
//		
		
		return false;
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
		
		String studentId = "thisstudentdoesnotexist";
		String role = "student";

		LandingService landingService = new LandingService();
		
		ModelAndView modelAndView = landingService.getModelAndViewByRoleAndUserId(role, studentId);

		if(modelAndView.getViewName().equals("STUDENT_LANDING")) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public boolean validParent() {
		
		String parentId = "23";
		
//		LandingService landingService = newLandingService();
//		LandingPageDto landingPageDto = landingService.retrieveLandingPageData(parentId);
//		
//		if(landingPageDto.type = PageType.PARENT) {
//			return true;
//		} else {
//			return false;
//		}
		
		return false;
	}
	
	public boolean invalidParent() {
		
		String parentId = "thisparentdoesnotexist";
		
//		LandingService landingService = newLandingService();
//		LandingPageDto landingPageDto = landingService.retrieveLandingPageData(parentId);
//		
//		if(landingPageDto == null) {
//			return true;
//		} else {
//			return false;
//		}
//		
		
		return false;
	}
	
	public boolean nullUserId() {
		
	String userId = null;
		
//		LandingService landingService = newLandingService();
//		LandingPageDto landingPageDto = landingService.retrieveLandingPageData(userId);
//		
//		if(landingPageDto == null) {
//			return true;
//		} else {
//			return false;
//		}
//		
		
		return false;
	}
	
	public boolean emptyUserId() {
		
	String userId = "";
		
//		LandingService landingService = newLandingService();
//		LandingPageDto landingPageDto = landingService.retrieveLandingPageData(userId);
//		
//		if(landingPageDto == null) {
//			return true;
//		} else {
//			return false;
//		}
//		
		
		return false;
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
	                +"<br/>emptyUserId: " + (emptyUserId() ? "Passed" : "Failed");
	    }
	
}
