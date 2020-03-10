package com.oneconnect.OneConnect.Test;

import com.oneconnect.OneConnect.Login.AssignmentService;

public class GetAssignmentTest{
	
	private boolean validAssignId{
		//to check that the proper assignment is returned,
		//we check the title of the returned assignment against its known value from the database.
		
		AssignmentService aService = new AssignmentService;
		assignId = "10054";
		
		if (aService.getAssignment(assignId).title == "Implement Features and Panic")
			return true;
		else
			return false;
		
		
	}
	
	private boolean notANumberAssignId{
		
		AssignmentService aService = new AssignmentService;
		assignId = Float.NaN;
		
		if (aService.getAssignment(assignId) == null)
			return true;
		else
			return false;

	}
	
	private boolean nullAssignId{
		
		AssignmentService aService = new AssignmentService;
		assignId = null;
		
		if (aService.getAssignment(assignId) == null)
			return true;
		else
			return false;

	}
	
	private boolean assignNotFound{
		
		AssignmentService aService = new AssignmentService;
		assignId = "426969" //not in the Assignments database
		
		if (aService.getAssignment(assignId) == null)
			return true;
		else
			return false;

	}
	
	private boolean emptyIdString{
		
		AssignmentService aService = new AssignmentService;
		assignId = "";
		
		if (aService.getAssignment(assignId) == null)
			return true;
		else
			return false;

	}
	
	private boolean numClassAssignments{
		
		AssignmentService aService = new AssignmentService;
		classId = "5252" //This class is known to have two assignments in the database
		String[] assignmentsForThisClass = aService.getAssignmentsFromClass(classId)
		
		if (assignmentsForThisClass.length == 2)
			return true;
		else
			return false;
		
	}
	
	public String runTests(){
		return "<br/><br/>GetAssignment Tests:"
                +"<br/>validAssignId: " + (validAssignId() ? "Passed" : "Failed")
                +"<br/>notANumberAssignId: " + (notANumberAssignId() ? "Passed" : "Failed")
                +"<br/>nullAssignId: " + (nullAssignId() ? "Passed" : "Failed")
                +"<br/>assignNotFound: " + (assignNotFound() ? "Passed" : "Failed")
                +"<br/>emptyIdString: " + (emptyIdString() ? "Passed" : "Failed")
                +"<br/>numClassAssignments: " + (numClassAssignments() ? "Passed" : "Failed")
		
	}
}