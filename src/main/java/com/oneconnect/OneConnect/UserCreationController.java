package com.oneconnect.OneConnect;

import com.oneconnect.OneConnect.UserCreation.UserCreationService;
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
        UserCreationService userCreationService = new UserCreationService();
        List<String> userRoles = loginService.retrieveRole(id);
        if(role.equals("default") && userRoles.size() > 0) {
            role = userRoles.get(0);
        }
        if(!userRoles.contains(role)) {
            modelAndView.setViewName("forbidden");
        } else {
            modelAndView.addObject("userId", id);
            modelAndView.addObject("role", role);
            modelAndView.addObject("name", userCreationService.getByUserId(id));
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
    public String getUser(String user, String role) {
        UserCreationService userCreationService = new UserCreationService();
        LoginService loginService = new LoginService();
        List<String> roles = loginService.retrieveRole(user);
        if(role.equals("default")) {
            role = roles.get(0);
        }
        if(!roles.contains(role)) {
            user = new String();
        }  /* else if(role.equals("student")) {
            user = userCreationService.getByUserId();
        }*/else {
            user = new String();
        }
        return user;
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public JSONArray getUserById(String user, String role) {
        JSONArray users = new JSONArray();
        UserCreationService userCreationService = new UserCreationService();
        LoginService loginService = new LoginService();
        List<String> roles = loginService.retrieveRole(user);
        if(role.equals("default")) {
            role = roles.get(0);
        }
        if(!roles.contains(role)) {
            users = new JSONArray();
        } else if(role.equals("parent")) {
            users = userCreationService.getByRole(role);
        } else {
            users = new JSONArray();
        }
        return users;
    }

    @RequestMapping("/getByRole")
    @ResponseBody
    public JSONArray getByRole(String role) {
        UserCreationService userCreationService = new UserCreationService();
        return userCreationService.getByRole(role);
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public JSONArray getAllUsers(String course) {
        UserCreationService userCreationService = new UserCreationService();
        return userCreationService.getAllUsers();
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public boolean updateUser (String name, List<String> role, String userId, List<String> classes, JSONArray children) {
        UserCreationService userCreationService = new UserCreationService();
        boolean update = false;
        LoginService loginService = new LoginService();
        List<String> roles = loginService.retrieveRole(userId);
        if(role.equals("default")) {
            //role = roles.get(0);
            update = true;
        }

        return update;
    }

}