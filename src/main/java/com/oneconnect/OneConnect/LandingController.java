package com.oneconnect.OneConnect;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oneconnect.OneConnect.Landing.LandingService;

@Controller
public class LandingController {

    @PostMapping("/landing")
    @ResponseBody
    public ModelAndView landing (@RequestParam(defaultValue = "f") String id, @RequestParam String role) {
    	
    	LandingService landingService = new LandingService();
        
        return landingService.getModelAndViewByRoleAndUserId(role, id); //Switch logic moved into service so it can used by unit tests
    }
    
    @PostMapping("/getLandingCourses")
    @ResponseBody
    public List<String> getLandingCourses (@RequestParam String userId) {
        LandingService landingService = new LandingService();
        List<String> courseIds = landingService.retrieveCourses(userId);
        List<String> courseNames = new ArrayList<String>();
        for(String courseId : courseIds) {
        	courseNames.add(landingService.retrieveCourseName(courseId));
        	
        }
        
        return courseNames;
        

    }
}
