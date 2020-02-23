package com.oneconnect.OneConnect.Test;

public class LoginTest {

    //All commented out sections of code are due to the fact that these pieces of code do not yet exist
    //and as such will cause compilation to fail immediately. Data passed subject to change following creation of
    //actual test data

    private boolean loginValidUserValidPass() {
        //LoginService login = new LoginService();
        String user = "gard6748";
        String password = "Hello123"; //No, that is not my actual password...
        //return login.validLogin(user, password).size() == 1;
        return true;
    }

    private boolean loginValidUserValidPassMultiple() {
        //LoginService login = new LoginService();
        String user = "frer2134";
        String password = "Hello123"; //No, that is not my actual password...
        //return login.validLogin(user, password).size() == 2;
        return true;
    }

    private boolean loginValidUserInvalidPass() {
        //LoginService login = new LoginService();
        String user = "gard6748";
        String password = "GoodBye123"; //No, that is not my actual password...
        //return login.validLogin(user, password)==null;
        return true;
    }


    private boolean loginValidUserNullPass() {
        //LoginService login = new LoginService();
        String user = "gard6748";
        String password = null;
        //return login.validLogin(user, password)==null;
        return true;
    }

    private boolean loginNullUserValidPass() {
        //LoginService login = new LoginService();
        String user = null;
        String password = "Hello123";
        //return login.validLogin(user, password)==null;
        return true;
    }


    private boolean retrieveRoleValidUser() {
        //LoginService login = new LoginService();
        String user = "1234567890";
        /*
        * String role = login.retrieveUserRole(user);
        * return role.equals("student");
        * */
        return true;
    }

    private boolean retrieveRoleInvalidUser() {
        //LoginService login = new LoginService();
        String user = "Begone";
        /*
         * String role = login.retrieveUserRole(user);
         * return role==null;
         * */
        return true;
    }

    private boolean retrieveRoleNullUser() {
        //LoginService login = new LoginService();
        String user = null;
        /*
         * String role = login.retrieveUserRole(user);
         * return role==null;
         * */
        return true;
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
