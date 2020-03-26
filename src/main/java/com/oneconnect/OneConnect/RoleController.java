package com.oneconnect.OneConnect;

import com.oneconnect.OneConnect.Grades.GradesService;
import com.oneconnect.OneConnect.Login.LoginService;
import com.oneconnect.OneConnect.Role.RoleService;
import com.oneconnect.OneConnect.User.User;
import com.oneconnect.OneConnect.User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoleController {

    @PostMapping("/roleManagement")
    @ResponseBody
    public ModelAndView roleManagement (@RequestParam(defaultValue = "f") String id, @RequestParam String role) {
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
            if (role.equals("admin")) {
                modelAndView.setViewName("roleManagement");
            } else {
                modelAndView.setViewName("forbidden");
            }
        }

        return modelAndView;
    }

    @PostMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers() {
        UserService userService = new UserService();
        return userService.getAllUsers();
    }

    @PostMapping("/getUserRoles")
    @ResponseBody
    public List<String> getUserRoles(String id) {
        RoleService roleService = new RoleService();
        return roleService.getUserRoles(id);
    }

    @PostMapping("/getUnusedRoles")
    @ResponseBody
    public List<String> getUnusedRoles(String id) {
        RoleService roleService = new RoleService();
        return roleService.getOtherRoles(id);
    }

    @PostMapping("/addUserRole")
    @ResponseBody
    public boolean addUserRoles(String id, String role) {
        System.out.println(id + " " + role);
        RoleService roleService = new RoleService();
        return roleService.addUserRole(id, role);
    }

    @PostMapping("/removeUserRole")
    @ResponseBody
    public boolean removeUserRoles(String id, String role) {
        System.out.println(id + " " + role);
        RoleService roleService = new RoleService();
        return roleService.removeUserRole(id, role);
    }
}
