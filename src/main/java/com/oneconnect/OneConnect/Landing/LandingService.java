package com.oneconnect.OneConnect.Landing;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;

import com.oneconnect.OneConnect.Utility;
import com.oneconnect.OneConnect.Course.CourseDTO;
import com.oneconnect.OneConnect.Login.LoginService;

public class LandingService {

	public ModelAndView getModelAndViewByRoleAndUserId(String role, String userId) {
		ModelAndView modelAndView = new ModelAndView();
        LoginService loginService = new LoginService();
        Utility utility  = new Utility();
        try {
	        if (role.equals("default")) {
	        	role = loginService.retrieveRole(userId).get(0);
		    }
		        
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
	                case "admin":
	                {
	                    modelAndView.setViewName("ADMIN_LANDING");
	                    modelAndView.addObject("userId", userId);
	                    modelAndView.addObject("userName", userName);
	                    modelAndView.addObject("role", "admin");
	                    break;
	                }
	                    
	                case "parent" :
	                {
	                    modelAndView.setViewName("PARENT_LANDING");
	                    modelAndView.addObject("userId", userId);
	                    modelAndView.addObject("userName", userName);
	                    modelAndView.addObject("role", "parent");
	                    break;
	                }
	                case "teacher" :
	                {
	                    modelAndView.setViewName("TEACHER_LANDING");
	                    List<String> courseIds = retrieveCourses(userId);
	                    List<String> courseNames = new ArrayList<String>();
	                    for(String courseId : courseIds) {
	                    	courseNames.add(retrieveCourseName(courseId));
	                    }
	                    
	                    modelAndView.addObject("courseNames", courseNames);
	                    modelAndView.addObject("userId", userId);
	                    modelAndView.addObject("userName", userName);
	                    modelAndView.addObject("role", "teacher");
	                    
	                    break;
	                }
	                case "student" :
	                {
	                    modelAndView.setViewName("STUDENT_LANDING");
	                    
	                    List<String> courseIds = retrieveCourses(userId);
	                    List<CourseDTO> courseDTOs = new ArrayList<>();
	                    
	                    for(String courseId : courseIds) {
	                    	CourseDTO dto = new CourseDTO();
	                    	dto.setCourseId(courseId);
	                    	dto.setName(retrieveCourseName(courseId));
	                    	courseDTOs.add(dto);
	                    	
	                    }
	                    
	                    modelAndView.addObject("courses", courseDTOs);
	                    modelAndView.addObject("userId", userId);
	                    modelAndView.addObject("userName", userName);
	                    modelAndView.addObject("role", "student");

	                    
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
	
	
	 public List<String> retrieveCourses(String id) {
	        Utility utility = new Utility();
	        List<String> courses = null;
	        JSONArray jsonArray = utility.jsonArrayGenerator("Users.json");
	        if(utility.numberChecker(id) && jsonArray != null) {
	        	courses = new ArrayList<>();
	            for (int i = 0; i < jsonArray.size(); i++) {
	                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
	                if(jsonObject.get("id").equals(id)) {
	                    JSONArray courseArray = (JSONArray)jsonObject.get("classes");
	                    for(int j = 0; j < courseArray.size(); j++) {
	                    	courses.add((String)courseArray.get(j));
	                    }
	                    break;
	                }
	            }
	        }
	        return courses;
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
	
	
	
}
