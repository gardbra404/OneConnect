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

	private boolean getAssignmentInfoValid() {
		String id = "10054";
//		AssignmentService assignmentService = new AssignmentService();
//		return assignmentService.getAssignment(id).getName().equals("Implement Features and Panic");

		return false;
	}

	private boolean getAssignmentInfoNan() {
		String id = "potato";
//		AssignmentService assignmentService = new AssignmentService();
//		return assignmentService.getAssignment(id) == null;

		return false;
	}
	private boolean getAssignmentInfoNull() {
		String id = null;
//		AssignmentService assignmentService = new AssignmentService();
//		return assignmentService.getAssignment(id) == null;

		return false;
	}
	private boolean getAssignmentInfoNotFound() {
		String id = "2457";
//		AssignmentService assignmentService = new AssignmentService();
//		return assignmentService.getAssignment(id) == null;

		return false;
	}

	private boolean getAssignmentsForClassValid() {
		String classId = "5252";
//		AssignmentService assignmentService = new AssignmentService();
//		return assignmentService.getClassAssignments(classId).size() == 2;

		return false;
	}

	private boolean getAssignmentsForClassNan() {
		String classId = "potato";
//		AssignmentService assignmentService = new AssignmentService();
//		return assignmentService.getClassAssignments(classId).size() == 0;

		return false;
	}
	private boolean getAssignmentsForClassNull() {
		String classId = null;
//		AssignmentService assignmentService = new AssignmentService();
//		return assignmentService.getClassAssignments(classId).size() == 0;

		return false;
	}
	private boolean getAssignmentsForClassNotFound() {
		String classId = "888888888";
//		AssignmentService assignmentService = new AssignmentService();
//		return assignmentService.getClassAssignments(classId).size() == 0;

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
	                +"<br/>nonNumericDuedate: " + (nonNumericDuedate() ? "Passed" : "Failed")
					+"<br/>getAssignmentInfoValid: " + (getAssignmentInfoValid() ? "Passed" : "Failed")
					+"<br/>getAssignmentInfoNan: " + (getAssignmentInfoNan() ? "Passed" : "Failed")
					+"<br/>getAssignmentInfoNull: " + (getAssignmentInfoNull() ? "Passed" : "Failed")
					+"<br/>getAssignmentInfoNotFound: " + (getAssignmentInfoNotFound() ? "Passed" : "Failed")
					+"<br/>getAssignmentsForClassValid: " + (getAssignmentsForClassValid() ? "Passed" : "Failed")
					+"<br/>getAssignmentsForClassNan: " + (getAssignmentsForClassNan() ? "Passed" : "Failed")
					+"<br/>getAssignmentsForClassNull: " + (getAssignmentsForClassNull() ? "Passed" : "Failed")
					+"<br/>getAssignmentsForClassNotFound: " + (getAssignmentsForClassNotFound() ? "Passed" : "Failed");
	    }
	
	
}

