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
public class GradesController {

    @PostMapping("/viewGrades")
    @ResponseBody
    public ModelAndView grades (@RequestParam(defaultValue = "f") String id, @RequestParam String role) {
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
        } else if(role.equals("student")) {
            grades = gradesService.studentGrades(user);
        } else {
            grades = new ArrayList<>();
        }
       return grades;
    }

    @RequestMapping("/parentGradeView")
    @ResponseBody
    public List<List<Grade>> retrieveParentGrades(String user, String role) {
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


    @RequestMapping("/getCourses")
    @ResponseBody
    public List<Course> retrieveCourses(String user) {
        GradesService gradesService = new GradesService();
        return gradesService.getCourses(user);
    }

    @RequestMapping("/getCourseInfo")
    @ResponseBody
    public CourseInfo retrieveCourseInfo(String course) {
        GradesService gradesService = new GradesService();
        return gradesService.getCourseInfo(course);
    }

    @RequestMapping("/updateGrades")
    @ResponseBody
    public boolean updateGrades (String classId, String studentId, String assignmentId,String grade, String user, String role) {
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

    @RequestMapping("/teacherGradeView")
    @ResponseBody
    public List<Grade> retrieveTeacherGrades(String user, String role) {
        List<Grade> grades;
        GradesService gradesService = new GradesService();
        LoginService loginService = new LoginService();
        List<String> roles = loginService.retrieveRole(user);
        if(role.equals("default")) {
            role = roles.get(0);
        }
        if(!roles.contains(role)) {
            grades = new ArrayList<>();
        } else if(role.equals("teacher")) {
            grades = gradesService.teacherGrades(user);
        } else {
            grades = new ArrayList<>();
        }
        return grades;
    }

    @PostMapping("/viewClassGrades")
    @ResponseBody
    public ModelAndView viewClassGrades(@RequestParam(defaultValue = "f") String id, @RequestParam String role, @RequestParam String classId) {
        ModelAndView modelAndView = new ModelAndView();
        GradesService gradesService = new GradesService();
        LoginService loginService = new LoginService();
        List<String> userRoles = loginService.retrieveRole(id);
        if (role.equals("default") && userRoles.size() > 0) {
            role = userRoles.get(0);
        }
        if (userRoles.contains(role)) {
            modelAndView.addObject("userId", id);
            modelAndView.addObject("role", role);
            modelAndView.addObject("name", gradesService.findName(id));
            modelAndView.addObject("school", "Kettering University");
            modelAndView.addObject("classId", classId);
            if (role.equals("teacher")) {
                modelAndView.setViewName("gradesTeacherClass");
            } else if (role.equals("student")) {
                modelAndView.setViewName("gradesStudentClass");
            } else {
                modelAndView.setViewName("forbidden");
            }
        } else {
            modelAndView.setViewName("forbidden");
        }
        return modelAndView;
    }

    @RequestMapping("/getStudentClassGrades")
    @ResponseBody
    public List<Grade> getStudentClassGrades(String studentId, String classId) {
        return new GradesService().getStudentClassGrades(studentId, classId);
    }

    @RequestMapping("/getTeacherClassGrades")
    @ResponseBody
    public List<Grade> getTeacherClassGrades(String classId) {
        return  new GradesService().getTeacherGradesForClass(classId);
    }
}
