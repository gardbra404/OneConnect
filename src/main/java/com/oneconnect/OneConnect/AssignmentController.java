package com.oneconnect.OneConnect;

import com.oneconnect.OneConnect.Assignment.AssignmentService;
import com.oneconnect.OneConnect.Grades.Assignment;
import com.oneconnect.OneConnect.Grades.GradesService;
import com.oneconnect.OneConnect.Login.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AssignmentController {

    @PostMapping("/assignments")
    @ResponseBody
    public ModelAndView assignmentView (@RequestParam(defaultValue = "f") String id, @RequestParam String role, @RequestParam String classId) {
        ModelAndView modelAndView = new ModelAndView();
        LoginService loginService = new LoginService();
        GradesService gradesService = new GradesService();
        List<String> roles = loginService.retrieveRole(id);
        if (role.equals("default") && roles.size() > 0) {
            role = roles.get(0);
        }
        if (roles.contains(role)) {
            modelAndView.addObject("name", gradesService.findName(id));
            modelAndView.addObject("school", "Kettering University");
            modelAndView.addObject("userId", id);
            modelAndView.addObject("role", role);
            modelAndView.addObject("classId", classId);
            if (role.equals("teacher")){
                modelAndView.setViewName("AssignmentListTeacher");
            } else if (role.equals("student")) {
                modelAndView.setViewName("AssignmentListStudent");
            } else {
                modelAndView.setViewName("forbidden");
            }
        } else {
            modelAndView.setViewName("forbidden");
        }
        return modelAndView;
    }

    @PostMapping("/getAssignments")
    @ResponseBody
    public List<Assignment> getAssignmentsForClass(String classId) {
        return new AssignmentService().getAssignments(classId);
    }

    @PostMapping("/retrieveAssignmentInfo")
    @ResponseBody
    public ModelAndView retrieveAssignmentDetails(@RequestParam String classId, @RequestParam String assignmentId,
                                                  @RequestParam String id, @RequestParam String role) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewAssignment");
        AssignmentService assignmentService = new AssignmentService();
        Assignment assignment = assignmentService.getAssignment(assignmentId);
        if (assignment != null) {
            modelAndView.addObject("userId", id);
            modelAndView.addObject("role", role);
            modelAndView.addObject("title", assignment.getName());
            modelAndView.addObject("points", assignment.getScore());
            modelAndView.addObject("description", assignment.getDescription());
            modelAndView.addObject("name", new GradesService().findName(id));
            modelAndView.addObject("classId", classId);
            modelAndView.addObject("school", "Kettering University");
        }
        return modelAndView;
    }

    @PostMapping("/addAssignment")
    @ResponseBody
    public ModelAndView addAssignmentPage(@RequestParam String id, @RequestParam String role, @RequestParam String classId) {
        ModelAndView modelAndView = new ModelAndView();
        LoginService loginService = new LoginService();
        GradesService gradesService = new GradesService();
        List<String> roles = loginService.retrieveRole(id);
        if (role.equals("default") && roles.size() > 0) {
            role = roles.get(0);
        }
        if (roles.contains(role)) {
            modelAndView.addObject("name", gradesService.findName(id));
            modelAndView.addObject("school", "Kettering University");
            modelAndView.addObject("userId", id);
            modelAndView.addObject("role", role);
            modelAndView.addObject("classId", classId);
            if (role.equals("teacher")){
                modelAndView.setViewName("addAssignment");
            } else {
                modelAndView.setViewName("forbidden");
            }
        } else {
            modelAndView.setViewName("forbidden");
        }
        return modelAndView;
    }

    @PostMapping("/addNewAssignment")
    @ResponseBody
    public boolean addNewAssignmentToClass(String classId, String title, String description, String score) {
        return new AssignmentService().addAssignment(classId, title, score, description);
    }
}
