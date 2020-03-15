package com.oneconnect.OneConnect;

import com.oneconnect.OneConnect.Test.*;
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
        LandingTest landingTest = new LandingTest();
        UserCreationTest userCreationTest = new UserCreationTest();
        AssignmentTest assignmentTest = new AssignmentTest();
        RoleTest roleTest = new RoleTest();
        return "TestResults:" + loginTest.runTests() + gradesTest.runTests() + landingTest.runTests()
                + roleTest.runTests() + assignmentTest.runTests();
    }
}
