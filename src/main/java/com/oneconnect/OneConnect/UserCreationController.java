package com.oneconnect.OneConnect;

import com.oneconnect.OneConnect.Grades.Course;
import com.oneconnect.OneConnect.Grades.CourseInfo;
import com.oneconnect.OneConnect.Grades.Grade;
import com.oneconnect.OneConnect.Grades.GradesService;
import com.oneconnect.OneConnect.Login.LoginService;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserCreationController {

    @PostMapping("/createUser")
    @ResponseBody
    public ModelAndView createUser (@RequestParam(defaultValue = "f") String id, @RequestParam String role) {
        ModelAndView modelAndView = new ModelAndView();
        LoginService loginService = new LoginService();
        GradesService gradesService = new GradesService();
        List<String> userRoles = loginService.retrieveRole(id);
        if(role.equals("default") && userRoles.size() > 0) {
            role = userRoles.get(0);
        }
        if(!userRoles.contains(role)) {
            modelAndView.setViewName("forbidden");
        } else {
            modelAndView.addObject("userId", id);
            modelAndView.addObject("role", role);
            modelAndView.addObject("name", gradesService.findName(id));
            //For right now, the school name is hard coded
            modelAndView.addObject("school", "Kettering University");
            if (role.equals("teacher")) {
                modelAndView.setViewName("gradesTeacher");
            } else if (role.equals("student")) {
                modelAndView.setViewName("gradesStudent");
            } else if (role.equals("parent")){
                modelAndView.setViewName("gradesParent");
            }else{
                modelAndView.setViewName("forbidden");
            }
        }

        return modelAndView;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public List<Grade> getUser(String user, String role) {
        List<Grade> grades = new ArrayList<>();
        GradesService gradesService = new GradesService();
        LoginService loginService = new LoginService();
        List<String> roles = loginService.retrieveRole(user);
        if(role.equals("default")) {
            role = roles.get(0);
        }
        if(!roles.contains(role)) {
            grades = new ArrayList<>();
        } else if(role.equals("student")) {
            grades = gradesService.studentGrades(user);
        } else {
            grades = new ArrayList<>();
        }
        return grades;
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public List<List<Grade>> getUserById(String user, String role) {
        List<List<Grade>> grades = new ArrayList<>();
        GradesService gradesService = new GradesService();
        LoginService loginService = new LoginService();
        List<String> roles = loginService.retrieveRole(user);
        if(role.equals("default")) {
            role = roles.get(0);
        }
        if(!roles.contains(role)) {
            grades = new ArrayList<>();
        } else if(role.equals("parent")) {
            grades = gradesService.parentGrades(user);
        } else {
            grades = new ArrayList<>();
        }
        return grades;
    }

    @RequestMapping("/getByRole")
    @ResponseBody
    public List<Course> getByRole(String user) {
        GradesService gradesService = new GradesService();
        return gradesService.getCourses(user);
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public CourseInfo getAllUsers(String course) {
        GradesService gradesService = new GradesService();
        return gradesService.getCourseInfo(course);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public boolean updateUser (String classId, String studentId, String assignmentId,String grade, String user, String role) {
        GradesService gradesService = new GradesService();
        boolean update = false;
        LoginService loginService = new LoginService();
        List<String> roles = loginService.retrieveRole(user);
        if(role.equals("default")) {
            role = roles.get(0);
        }
        if(!roles.contains(role)) {
            update = false;
        } else if (gradesService.roleCheck(role)) {
            if(gradesService.doesGradeExist(studentId, assignmentId, classId)) {
                update = gradesService.updateGrade(studentId, assignmentId, classId, grade);
            } else {
                update = gradesService.createGrades(studentId, assignmentId, classId, grade);
            }
        }

        return update;
    }

}