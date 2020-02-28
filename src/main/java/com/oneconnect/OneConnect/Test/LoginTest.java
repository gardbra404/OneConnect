package com.oneconnect.OneConnect.Test;

import com.oneconnect.OneConnect.Login.LoginService;

import java.util.List;

public class LoginTest {

    //All commented out sections of code are due to the fact that these pieces of code do not yet exist
    //and as such will cause compilation to fail immediately. Data passed subject to change following creation of
    //actual test data

    private boolean loginValidUserValidPass() {
        LoginService login = new LoginService();
        String user = "gard6748";
        String password = "Hello123"; //No, that is not my actual password...
        return login.login(user, password).getId().equals("123");
    }

    private boolean loginValidUserValidPassMultiple() {
        LoginService login = new LoginService();
        String user = "gard6748";
        String password = "Hello123"; //No, that is not my actual password...

        return login.login(user, password).getRoles().size() == 2;
    }

    private boolean loginValidUserInvalidPass() {
        LoginService login = new LoginService();
        String user = "gard6748";
        String password = "GoodBye123"; //No, that is not my actual password...
        return login.login(user, password).getId().equals("-1");
    }


    private boolean loginValidUserNullPass() {
        LoginService login = new LoginService();
        String user = "gard6748";
        String password = null;
        return login.login(user, password).getId().equals("-1");
    }

    private boolean loginNullUserValidPass() {
        LoginService login = new LoginService();
        String user = null;
        String password = "Hello123";
        return login.login(user, password).getId().equals("-1");
    }


    private boolean retrieveRoleValidUser() {
        LoginService login = new LoginService();
        String user = "126";

         List<String> role = login.retrieveRole(user);
         return role.get(0).equals("parent");
    }

    private boolean retrieveRoleInvalidUser() {
        LoginService login = new LoginService();
        String user = "Begone";

         List<String> role = login.retrieveRole(user);
         return role==null;
    }

    private boolean retrieveRoleNullUser() {
        LoginService login = new LoginService();
        String user = null;

          List<String> role = login.retrieveRole(user);
          return role==null;
    }

    public String runTests() {
        return "<br/><br/>Login Test:"
                +"<br/>loginValidUserValidPass: " + (loginValidUserValidPass() ? "Passed" : "Failed")
                +"<br/>loginValidUserValidPassMultiple: " + (loginValidUserValidPassMultiple() ? "Passed" : "Failed")
                +"<br/>loginValidUserInvalidPass: " + (loginValidUserInvalidPass() ? "Passed" : "Failed")
                +"<br/>loginValidUserNullPass: " + (loginValidUserNullPass() ? "Passed" : "Failed")
                +"<br/>loginNullUserValidPass: " + (loginNullUserValidPass() ? "Passed" : "Failed")
                +"<br/>retrieveRoleValidUser: " + (retrieveRoleValidUser() ? "Passed" : "Failed")
                +"<br/>retrieveRoleInvalidUser: " + (retrieveRoleInvalidUser() ? "Passed" : "Failed")
                +"<br/>retrieveRoleNullUser: " + (retrieveRoleNullUser() ? "Passed" : "Failed");
    }
}
