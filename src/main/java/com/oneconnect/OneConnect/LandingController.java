package com.oneconnect.OneConnect;

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
    
}
