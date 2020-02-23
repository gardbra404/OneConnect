package com.oneconnect.OneConnect;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TempController {
    @RequestMapping("/")
    @ResponseBody
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping(value = "/hello")
    @ResponseBody
    public tmpObj welcome(String hello, String i) {
        System.out.println(i);
        tmpObj t = new tmpObj();
        t.setPhrase(hello);
        return t;
    }
}
