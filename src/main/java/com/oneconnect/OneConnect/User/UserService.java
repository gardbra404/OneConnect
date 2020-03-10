package com.oneconnect.OneConnect.User;

import com.oneconnect.OneConnect.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public User getUser(String id) {
        Utility utility = new Utility();
        User user = null;
        if (utility.numberChecker(id)) {
            JSONArray users = utility.jsonArrayGenerator("Users.json");
            for (int i = 0; i < users.size(); i++) {
                JSONObject fileUser = (JSONObject) users.get(i);
                if (fileUser.get("id").equals(id)){
                    user = generateUser(fileUser);
                }
            }
        }
        return user;
    }

    public List<User> getAllUsers() {
        Utility utility = new Utility();
        List<User> users = new ArrayList<>();
        JSONArray fileUsers = utility.jsonArrayGenerator("Users.json");
        for (int i = 0; i < fileUsers.size(); i++) {
            JSONObject fileUser = (JSONObject) fileUsers.get(i);
            User user = generateUser(fileUser);
            users.add(user);
        }
        return users;
    }

    private User generateUser(JSONObject fileUser) {
        Utility utility = new Utility();
        User user = new User();
        user.setId((String)fileUser.get("id"));
        user.setName((String)fileUser.get("name"));
        user.setClasses(utility.convertJsonArray((JSONArray) fileUser.get("classes")));
        user.setRole(utility.convertJsonArray((JSONArray) fileUser.get("role")));
        user.setChildren(new ArrayList<>());
        JSONArray children = (JSONArray) fileUser.get("children");
        for (int j = 0; j < children.size(); j++) {
            JSONObject child = (JSONObject) children.get(j);
            user.getChildren().add(new Child((String) child.get("id"), (String) child.get("allowed")));
        }
        return user;
    }
}
