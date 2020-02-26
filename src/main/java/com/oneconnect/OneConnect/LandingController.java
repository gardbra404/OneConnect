package com.oneconnect.OneConnect;

import com.oneconnect.OneConnect.Login.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LandingController {

    @PostMapping("/landing")
    @ResponseBody
    public ModelAndView landing (@RequestParam(defaultValue = "f") String id, @RequestParam String role) {
        LoginService loginService = new LoginService();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userId", id);
        modelAndView.addObject("role", role);
        if (role.equals("default")) {
            role = loginService.retrieveRole(id).get(1);
        }
        if(id.equals("f")) {
            modelAndView.setViewName("forbidden");
        } else {
            switch(role) {
                case "admin":
                    modelAndView.setViewName("TEMP4");
                    break;
                case "parent" :
                    modelAndView.setViewName("TEMP3");
                    break;
                case "teacher" :
                    modelAndView.setViewName("TEMP2");
                    break;
                case "student" :
                    modelAndView.setViewName("TEMP");
                    break;
                default:
                    modelAndView.setViewName("forbidden");
                    break;
            }
        }
        return modelAndView;
    }
}
