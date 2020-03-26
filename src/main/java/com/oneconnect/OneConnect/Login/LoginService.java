package com.oneconnect.OneConnect.Login;

import com.oneconnect.OneConnect.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class LoginService {

    public UserLogin login (String user, String pass) {
        Utility utility = new Utility();
        UserLogin userLogin = new UserLogin("-1", new ArrayList<>());
        String id = null;
        List<String> roles = new ArrayList<>();
        JSONArray jsonArray = utility.jsonArrayGenerator("Login.json");
        if(user != null && user.length() > 0 && pass != null && pass.length() > 0 && jsonArray != null) {
            for(int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                if(jsonObject.get("user").equals(user) && jsonObject.get("pass").equals(pass)) {
                    id = (String)jsonObject.get("id");
                    List<String> role = retrieveRole(id);
                    if(role != null) {
                        roles = role;
                    }
                    userLogin = new UserLogin(id, roles);
                    break;
                }
            }

        }
        return userLogin;
    }

    public List<String> retrieveRole(String id) {
        Utility utility = new Utility();
        List<String> roles = null;
        JSONArray jsonArray = utility.jsonArrayGenerator("Users.json");
        if(utility.numberChecker(id) && jsonArray != null) {
            roles = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                if(jsonObject.get("id").equals(id)) {
                    JSONArray role = (JSONArray)jsonObject.get("role");
                    for(int j = 0; j < role.size(); j++) {
                        roles.add((String)role.get(j));
                    }
                    break;
                }
            }
        }
        return roles;
    }


}
