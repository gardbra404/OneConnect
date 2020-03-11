package com.oneconnect.OneConnect;

import com.oneconnect.OneConnect.Login.LoginService;
import com.oneconnect.OneConnect.Login.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

@Controller
public class LoginController {



    @RequestMapping("/")
    @ResponseBody
    public ModelAndView welcome() {
        File direct = new File("C:/temp");
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
