package com.oneconnect.OneConnect;

import com.oneconnect.OneConnect.Test.GradesTest;
import com.oneconnect.OneConnect.Test.LoginTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        LoginTest loginTest = new LoginTest();
        GradesTest gradesTest = new GradesTest();
        return "TestResults:" + loginTest.runTests() + gradesTest.runTests();
    }
}
