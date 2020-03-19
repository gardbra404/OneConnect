package com.oneconnect.OneConnect.Course;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;

import com.oneconnect.OneConnect.Utility;
import com.oneconnect.OneConnect.Grades.Grade;
import com.oneconnect.OneConnect.Grades.GradesService;
import com.oneconnect.OneConnect.Login.LoginService;

public class CourseService {

	public ModelAndView getModelAndViewByRoleAndUserIdAndClassId(String role, String userId, String courseId) {
		
		ModelAndView modelAndView = new ModelAndView();
		LoginService loginService = new LoginService();
		GradesService gradesService = new GradesService();
		Utility utility = new Utility();
		
        try {
	        if (role.equals("default")) {
	        	role = loginService.retrieveRole(userId).get(0);
		    }
		    modelAndView.addObject("courseId", courseId);
	        System.out.println("Role: " + role + " userId: " + userId);
	        
	        if(userId.equals("f") || !utility.numberChecker(userId)) {
	            modelAndView.setViewName("forbidden");
	        } else {
	        	String userName = retrieveUserName(userId);
	        	if(userName == null) {
	        		modelAndView.setViewName("forbidden");
	        		return modelAndView;
	        	}
	            switch(role) {
	                case "teacher" :
	                {
	                	
	                    modelAndView.setViewName("COURSE");
	                	String courseName = retrieveCourseName(courseId);
	                    modelAndView.addObject("courseName", courseName);
	                    modelAndView.addObject("userId", userId);
	                    modelAndView.addObject("userName", userName);
	                    
	                    List<String> assignmentNames = retrieveAssignmentNameListByCourseId(courseId);
	                    modelAndView.addObject("assignmentNames", assignmentNames);

	                    modelAndView.addObject("role", "teacher");
	                    
	                    break;
	                }
	                case "student" :
	                {
	                	
	                    modelAndView.setViewName("COURSE");
	                	String courseName = retrieveCourseName(courseId);
	                    modelAndView.addObject("courseName", courseName);
	                    modelAndView.addObject("userId", userId);
	                    modelAndView.addObject("userName", userName);
	                    
	                    List<String> assignmentNames = retrieveAssignmentNameListByCourseId(courseId);
	                    modelAndView.addObject("assignmentNames", assignmentNames);

	                    //Grades
	                    List<Grade> grades = gradesService.getStudentClassGrades(userId, courseId);
	                    
	                    int gradeTotal = 0;
	                    int studentTotal = 0;
	                    for(Grade grade : grades) {
	                    	gradeTotal += Integer.parseInt(grade.getAssignmentTotal());
	                    	studentTotal += Integer.parseInt(grade.getScore());
	                    }
	                    
	                    double percent = ((double)studentTotal / gradeTotal) * 100;
	                    percent = Math.round(percent * 100.0) / 100.0;
	                    
	                    modelAndView.addObject("courseTotal", gradeTotal);
	                    modelAndView.addObject("studentTotal", studentTotal);
	                    modelAndView.addObject("percent", percent);

	                    
	                    modelAndView.addObject("grades", grades);
	                    modelAndView.addObject("role", "student");
	                    modelAndView.addObject("isStudent", 1);
	                    
	                    

	                    
	                    break;
	                }
	                default:
	                    modelAndView.setViewName("forbidden");
	                    break;
	            }
	        }
	        return modelAndView;
        } catch(Exception e) {
        	System.out.println("Unable to process userId: "+ userId +", role: " + role);
            modelAndView.setViewName("forbidden");
        }
        return modelAndView;
		
	}
	
	
	public String retrieveCourseName(String courseId) {
		 Utility utility = new Utility();
	        String courseName = null;
	        JSONArray jsonArray = utility.jsonArrayGenerator("Class.json");
	        if(utility.numberChecker(courseId) && jsonArray != null) {
	            for (int i = 0; i < jsonArray.size(); i++) {
	                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
	                if(jsonObject.get("id").equals(courseId)) {
	                    courseName = (String) jsonObject.get("name");
	                    
	          	      	return courseName;
	                }
	            }
	        }
	      return courseName;
	}
	
	public String retrieveUserName(String userId) {
		 Utility utility = new Utility();
	        String userName = null;
	        JSONArray jsonArray = utility.jsonArrayGenerator("Users.json");
	        if(utility.numberChecker(userId) && jsonArray != null) {
	            for (int i = 0; i < jsonArray.size(); i++) {
	                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
	                if(jsonObject.get("id").equals(userId)) {
	                    userName = (String) jsonObject.get("name");
	                    
	          	      	return userName;
	                }
	            }
	        }
	      return userName;
	}
	
	
	
	
	public List<String> retrieveAssignmentNameListByCourseId(String courseId) {
		Utility utility = new Utility();
        JSONArray courseJSONArray = utility.jsonArrayGenerator("Class.json");
        JSONArray assignmentJSONArray = utility.jsonArrayGenerator("Assignments.json");

        List<String> assignmentIds = new ArrayList<>();
        List<String> assignmentNames = new ArrayList<>();

	    if(utility.numberChecker(courseId) && courseJSONArray != null && assignmentJSONArray != null) {
	    	for (int i = 0; i < courseJSONArray.size(); i++) {
	    		JSONObject jsonObject = (JSONObject)courseJSONArray.get(i);
	    		if(jsonObject.get("id").equals(courseId)) {
	    			JSONArray assignmentIdArray = (JSONArray)jsonObject.get("assignments");
	    			
	    			for(int j = 0; j < assignmentIdArray.size(); j++) {
	    				assignmentIds.add((String)assignmentIdArray.get(j));
	    			}
                  break;
	    		}
	    	}
	    	
	    	for(String assignmentId : assignmentIds) {
	    		String assignmentName = retrieveAssignmentNameByAssignmentId(assignmentId);
	    		assignmentNames.add(assignmentName);
	    	}
	    }
	    
    	return assignmentNames;

	}
	
	public String retrieveAssignmentNameByAssignmentId(String assignmentId) {
		Utility utility = new Utility();
        JSONArray jsonArray = utility.jsonArrayGenerator("Assignments.json");
        String assignmentName = null;
        if(utility.numberChecker(assignmentId) && jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                if(jsonObject.get("id").equals(assignmentId)) {
                	assignmentName = (String) jsonObject.get("title");
          	      	return assignmentName;
                }
            }
        }
        return assignmentName;
	}
	

}
