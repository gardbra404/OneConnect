package com.oneconnect.OneConnect.Test;

public class AssignmentTest {

	public boolean validClassValidAssignValidPointsValidDuedate() {
		
		String userId = "username";
		String teacherId = "teacher";
		String points = "100";
		String description = "asdfasf";
		String courseId = "class";
		String duedate = "02242020";
		
//		AssignmentService assignmnentService = new AssignmentService();
//		On failure, the assignmentService returns a null assignment
//		if(assignmentService.createNewAssignment(userId, teacherId, courseId, points, description, duedate) == null) {
//			return false;
//		} else {
//			return true; 
//		}
		
		return false;
				
	}
	
	public boolean nullClass() {
		
		String userId = "username";
		String teacherId = "teacher";
		String points = "100";
		String description = "asdfasf";
		String courseId = null;
		String duedate = "02242020";
		
//		AssignmentService assignmnentService = new AssignmentService();
//		On failure, the assignmentService returns a null assignment
//		if(assignmentService.createNewAssignment(userId, teacherId, courseId, points, description, duedate) == null) {
//			return true;
//		} else {
//			return false; 
//		}
		
		return false;
		
	}
	
	public boolean nonNumericClass() {
		
		String userId = "username";
		String teacherId = "teacher";
		String points = "100";
		String description = "asdfasf";
		String courseId = "notanumber";
		String duedate = "02242020";
		
//		AssignmentService assignmnentService = new AssignmentService();
//		On failure, the assignmentService returns a null assignment
//		if(assignmentService.createNewAssignment(userId, teacherId, courseId, points, description, duedate) == null) {
//			return true;
//		} else {
//			return false; 
//		}
		
		
		return false;
	}
	
	public boolean nonNumericPoints() {
		
		String userId = "username";
		String teacherId = "teacher";
		String point = "asdfadsf";
		String description = "asdfasf";
		String courseId = "23";
		String duedate = "02242020";
		
//		AssignmentService assignmnentService = new AssignmentService();
//		
//		On failure, the assignmentService returns a null assignment
//		if(assignmentService.createNewAssignment(userId, teacherId, courseId, points, description, duedate) == null) {
//			return true;
//		} else {
//			return false; 
//		}
		
		return false;
		
	}
	
	public boolean negativePoints() {
		
		String userId = "username";
		String teacherId = "teacher";
		String points = "-5";
		String description = "asdfasf";
		String courseId = null;
		String duedate = "02242020";
		
//		AssignmentService assignmnentService = new AssignmentService();
//		
//		On failure, the assignmentService returns a null assignment
//		if(assignmentService.createNewAssignment(userId, teacherId, courseId, points, description, duedate) == null) {
//			return true;
//		} else {
//			return false; 
//		}
		
		
		return false;
	}
	
	public boolean nullPoints() {
		
		String userId = "username";
		String teacherId = "teacher";
		String points = null;
		String description = "asdfasf";
		String courseId = "2";
		String duedate = "02242020";
		
//		AssignmentService assignmnentService = new AssignmentService();
//		
//		On failure, the assignmentService returns a null assignment
//		if(assignmentService.createNewAssignment(userId, teacherId, courseId, points, description, duedate) == null) {
//			return true;
//		} else {
//			return false; 
//		}
		
		
		return false;
	}
	
	public boolean nullDuedate() {
		
		String userId = "username";
		String teacherId = "teacher";
		String points = "100";
		String description = "asdfasf";
		String courseId = "2";
		String duedate = null;
		
//		AssignmentService assignmnentService = new AssignmentService();
//		
//		On failure, the assignmentService returns a null assignment
//		if(assignmentService.createNewAssignment(userId, teacherId, courseId, points, description, duedate) == null) {
//			return true;
//		} else {
//			return false; 
//		}
		
		
		return false;
	}
	
	
	public boolean nonNumericDuedate() {
		
		String userId = "username";
		String teacherId = "teacher";
		String points = "100";
		String description = "asdfasf";
		String courseId = "2";
		String duedate = "asdfadf";
		
//		AssignmentService assignmnentService = new AssignmentService();
//		
//		On failure, the assignmentService returns a null assignment
//		if(assignmentService.createNewAssignment(userId, teacherId, courseId, points, description, duedate) == null) {
//			return true;
//		} else {
//			return false; 
//		}
		
		
		return false;
	}
	
	
	 public String runTests() {
	        return "<br/><br/>Assignment Test:"
	                +"<br/>validClassValidAssignValidPointsValidDuedate: " + (validClassValidAssignValidPointsValidDuedate() ? "Passed" : "Failed")
	                +"<br/>nullClass: " + (nullClass() ? "Passed" : "Failed")
	                +"<br/>nonNumericClass: " + (nonNumericClass() ? "Passed" : "Failed")
	                +"<br/>nonNumericPoints: " + (nonNumericPoints() ? "Passed" : "Failed")
	                +"<br/>negativePoints: " + (negativePoints() ? "Passed" : "Failed")
	                +"<br/>nullPoints: " + (nullPoints() ? "Passed" : "Failed")
	                +"<br/>nullDuedate: " + (nullDuedate() ? "Passed" : "Failed")
	                +"<br/>nonNumericDuedate: " + (nonNumericDuedate() ? "Passed" : "Failed");
	    }
	
	
}

