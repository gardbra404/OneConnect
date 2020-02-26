package com.oneconnect.OneConnect;

import com.oneconnect.OneConnect.Login.LoginService;
import com.oneconnect.OneConnect.Login.UserLogin;
import org.apache.catalina.User;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

@Controller
public class LoginController {



    @RequestMapping("/")
    @ResponseBody
    public ModelAndView welcome() {
        File direct = new File("C:\\temp");
        if (!direct.exists()){
            direct.mkdir();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping(value = "/login")
    @ResponseBody
    public UserLogin login(String user, String pass) {
        LoginService loginService = new LoginService();
        return loginService.login(user, pass);
    }


}
