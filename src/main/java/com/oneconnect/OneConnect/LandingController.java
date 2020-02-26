package com.oneconnect.OneConnect;

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
        ModelAndView modelAndView = new ModelAndView();
        if (role.equals("default")) {

        }
        if(id.equals("f")) {
            modelAndView.setViewName("forbidden");
        } else {
            modelAndView.setViewName("TEMP");
        }
        return modelAndView;
    }
}
