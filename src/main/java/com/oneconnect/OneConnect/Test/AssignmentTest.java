package com.oneconnect.OneConnect.Test;

import com.oneconnect.OneConnect.Assignment.AssignmentService;

public class AssignmentTest {

	public boolean addAssignmentValidClassValidAssignValidPoints() {

		String title ="Test Assignment";
		String points = "100";
		String description = "I am just a test, I mean nothing";
		String courseId = "5253";

		return new AssignmentService().addAssignment(courseId, title, points, description);
		

	}

	public boolean addAssignentNullClass() {

		String title ="Test Assignment";
		String points = "100";
		String description = "I am just a test, I mean nothing";
		String courseId = null;

		return ! new AssignmentService().addAssignment(courseId, title, points, description);

	}

	public boolean addAssignentNonNumericClass() {

		String title ="Test Assignment";
		String points = "100";
		String description = "I am just a test, I mean nothing";
		String courseId = "potato";

		return! new AssignmentService().addAssignment(courseId, title, points, description);
	}

	public boolean addAssignentNonNumericPoints() {

		String title ="Test Assignment";
		String points = "100";
		String description = "I am just a test, I mean nothing";
		String courseId = "potato";

		return! new AssignmentService().addAssignment(courseId, title, points, description);

	}

	public boolean addAssignmentNegativePoints() {

		String title ="Test Assignment";
		String points = "-1";
		String description = "I am just a test, I mean nothing";
		String courseId = "5253";

		return! new AssignmentService().addAssignment(courseId, title, points, description);


		
	}

	public boolean addAssignmentNullPoints() {

		String title ="Test Assignment";
		String points = null;
		String description = "I am just a test, I mean nothing";
		String courseId = "5253";

		return! new AssignmentService().addAssignment(courseId, title, points, description);
	}
	
	public boolean addAssignmentNullTitle() {

		String title = null;
		String points = "100";
		String description = "I am just a test, I mean nothing";
		String courseId = "5253";

		return! new AssignmentService().addAssignment(courseId, title, points, description);
	}
	
	public boolean addAssignmentNullDescription() {

		String title ="Test Assignment";
		String points = "100";
		String description = null;
		String courseId = "5253";

		return! new AssignmentService().addAssignment(courseId, title, points, description);
	}



	private boolean getAssignmentInfoValid() {
		String id = "10054";
		AssignmentService assignmentService = new AssignmentService();
		return assignmentService.getAssignment(id).getName().equals("Implement Features and Panic");
	}

	private boolean getAssignmentInfoNan() {
		String id = "potato";
		AssignmentService assignmentService = new AssignmentService();
		return assignmentService.getAssignment(id) == null;

		
	}
	private boolean getAssignmentInfoNull() {
		String id = null;
		AssignmentService assignmentService = new AssignmentService();
		return assignmentService.getAssignment(id) == null;

		
	}
	private boolean getAssignmentInfoNotFound() {
		String id = "2457";
		AssignmentService assignmentService = new AssignmentService();
		return assignmentService.getAssignment(id) == null;

		
	}

	private boolean getAssignmentsForClassValid() {
		String classId = "5252";
		AssignmentService assignmentService = new AssignmentService();
		return assignmentService.getAssignments(classId).size() == 2;

		
	}

	private boolean getAssignmentsForClassNan() {
		String classId = "potato";
		AssignmentService assignmentService = new AssignmentService();
		return assignmentService.getAssignments(classId).size() == 0;

		
	}
	private boolean getAssignmentsForClassNull() {
		String classId = null;
		AssignmentService assignmentService = new AssignmentService();
		return assignmentService.getAssignments(classId).size() == 0;

		
	}
	private boolean getAssignmentsForClassNotFound() {
		String classId = "888888888";
		AssignmentService assignmentService = new AssignmentService();
		return assignmentService.getAssignments(classId).size() == 0;

		
	}

	public String runTests() {
		return "<br/><br/>Assignment Test:"
				+"<br/>addAssignmentValidClassValidAssignValidPoints: " + (addAssignmentValidClassValidAssignValidPoints() ? "Passed" : "Failed")
				+"<br/>addAssignentNullClass: " + (addAssignentNullClass() ? "Passed" : "Failed")
				+"<br/>addAssignentNonNumericClass: " + (addAssignentNonNumericClass() ? "Passed" : "Failed")
				+"<br/>addAssignentNonNumericPoints: " + (addAssignentNonNumericPoints() ? "Passed" : "Failed")
				+"<br/>addAssignmentNegativePoints: " + (addAssignmentNegativePoints() ? "Passed" : "Failed")
				+"<br/>addAssignmentNullPoints: " + (addAssignmentNullPoints() ? "Passed" : "Failed")
				+"<br/>addAssignmentNullTitle: " + (addAssignmentNullTitle() ? "Passed" : "Failed")
				+"<br/>addAssignmentNullDescription: " + (addAssignmentNullDescription() ? "Passed" : "Failed")
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