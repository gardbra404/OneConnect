package com.oneconnect.OneConnect;

import com.oneconnect.OneConnect.Grades.Grade;
import com.oneconnect.OneConnect.Grades.GradesService;
import com.oneconnect.OneConnect.Login.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradesController {

    @PostMapping("/viewGrades")
    @ResponseBody
    public ModelAndView grades (@RequestParam(defaultValue = "f") String id, @RequestParam String role) {
        ModelAndView modelAndView = new ModelAndView();
        LoginService loginService = new LoginService();
        List<String> userRoles = loginService.retrieveRole(id);
        if(role.equals("default") && userRoles.size() > 0) {
            role = userRoles.get(0);
        }
        if(!userRoles.contains(role)) {
            modelAndView.setViewName("forbidden");
        } else {
            modelAndView.addObject("userId", id);
            modelAndView.addObject("role", role);
            if(role.equals("teacher")) {
                modelAndView.setViewName("teacherGrades");
            } else if (role.equals("student") || role.equals("parent")){
                modelAndView.setViewName("gradesStudent");
            } else {
                modelAndView.setViewName("forbidden");
            }
        }

        return modelAndView;
    }

    @RequestMapping("/retrieveGrades")
    @ResponseBody
    public List<Grade> retrieveGrades(String user, String role) {
        List<Grade> grades = new ArrayList<>();
        GradesService gradesService = new GradesService();
        LoginService loginService = new LoginService();
        List<String> roles = loginService.retrieveRole(user);
        if(role.equals("default")) {
            role = roles.get(0);
        }
        if(!roles.contains(role)) {
            grades = new ArrayList<>();
        } else {
            switch(role) {
                case "parent":
                    break;
                case "teacher":
                    break;
                case "student":
                    grades = gradesService.studentGrades(user);
                    break;
                default:
                    grades = new ArrayList<>();
                    break;

            }
        }
       return grades;
    }
}
