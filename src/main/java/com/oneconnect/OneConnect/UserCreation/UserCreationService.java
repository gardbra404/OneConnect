package com.oneconnect.OneConnect.UserCreation;

import com.oneconnect.OneConnect.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserCreationService {

    //for testing purposes
    public boolean createUser (String name, List<String> role, String userId, List<String> classes, List<Child> children){
        return createUser(name, role, userId, classes, children, false);
    }

    @SuppressWarnings("unchecked")
    public boolean createUser (String name, List<String> role, String userId, List<String> classes, List<Child> children, boolean test) {
        Utility utility = new Utility();
        JSONArray copyUser = new JSONArray();
        boolean userCreated = false;
        boolean childrenValid = false;
        boolean classesValid = false;
        for(int classCount = 0; classCount < classes.size(); classCount++){
            String currentClass = classes.get(classCount);
            if(!utility.numberChecker(currentClass)){
                classesValid = false;
                break;
            }
            classesValid = true;
        }
        for(int childCount = 0; childCount < children.size(); childCount++){
            Child currentChild = children.get(childCount);
            String childId = currentChild.getUserId();
            if(!utility.numberChecker(childId)){
                childrenValid = false;
                break;
            }
            childrenValid = true;
        }
        if (utility.numberChecker(userId) && childrenValid) {
            JSONArray userList = utility.jsonArrayGenerator("Users.json");
            for (int i = 0; i < userList.size(); i++) {
                JSONObject user = (JSONObject) userList.get(i);
                if (userId.equals(user.get("userId"))) {
                    JSONObject replaceUser = new JSONObject();
                    replaceUser.put("name", user.get("name"));

                    JSONArray roles = (JSONArray) user.get("role");
                    JSONObject newRoles = new JSONObject();
                    newRoles.put("role", role);
                    roles.add(newRoles);
                    replaceUser.put("role", roles);

                    replaceUser.put("userId", user.get("userId"));

                    JSONArray oldClasses = (JSONArray) user.get("classes");
                    JSONObject newClasses = new JSONObject();
                    newClasses.put("classes", classes);
                    oldClasses.add(newClasses);
                    replaceUser.put("classes", oldClasses);

                    JSONArray oldChildren = (JSONArray) user.get("children");
                    for(int j = 0; i < oldChildren.size(); i++) {
                        JSONObject newChildren = new JSONObject();
                        newChildren.put("userId", children.get(j));
                        newChildren.put("allowed", children.get(j));
                        oldChildren.add(newChildren);
                        replaceUser.put("children", oldChildren);
                    }
                    copyUser.add(replaceUser);
                } else {
                    copyUser.add(user);
                }
            }
            if(!test) {
                userCreated = utility.jsonWriter(copyUser.toJSONString(), "Users.json");
            } else {
                userCreated = true;
            }
        }
        return userCreated;
    }

    public boolean updateUser(String name, List<String> role, String userId, List<String> classes, List<Child> children) {
        return updateUser(name, role, userId, classes, children, false);
    }

    @SuppressWarnings("unchecked")
    public boolean updateUser(String name, List<String> role, String userId, List<String> classes, List<Child> children, boolean test) {
        Utility utility = new Utility();
        JSONArray copyUser = new JSONArray();
        boolean userUpdated = false;
        if (utility.numberChecker(userId)) {
            JSONArray userList = utility.jsonArrayGenerator("Users.json");
            for (int i = 0; i < userList.size(); i++) {
                JSONObject updateUser = (JSONObject) userList.get(i);
                if (userId.equals(updateUser.get("userId"))) {
                    updateUser.put("name", name);
                    updateUser.put("role", role);
                    updateUser.put("classes", classes);
                    updateUser.put("children", children);
                    copyUser.add(updateUser);
                } else {
                    copyUser.add(updateUser);
                }
            }
            if (!test) {
                userUpdated = utility.jsonWriter(copyUser.toJSONString(), "Grades.json");
            } else {
                userUpdated = true;
            }
        }
        return userUpdated;
    }

    public boolean doesUserExist (String name, String userId) {
        Utility utility = new Utility();
        boolean exists = false;
        if (name != null && userId != null) {
            JSONArray userList = utility.jsonArrayGenerator("Users.json");
            for (int i = 0; i < userList.size(); i++) {
                JSONObject user = (JSONObject) userList.get(i);
                if(userId.equals(user.get("userId")) && name.equals(user.get("name"))){
                    exists = true;
                    break;
                }
            }
        }
        return exists;
    }

    public JSONArray getUser(String name) {
        Utility utility = new Utility();
        JSONArray userList = new JSONArray();
        JSONArray users = utility.jsonArrayGenerator("Users.json");
        for (int i = 0; i < users.size(); i++) {
            JSONObject user = (JSONObject) users.get(i);
            if (name.equals(user.get("name"))){
                userList.add(user);
            }
        }
        return userList;
    }

    public JSONArray getByUserId(String userId) {
        Utility utility = new Utility();
        JSONArray userList = new JSONArray();
        JSONArray users = utility.jsonArrayGenerator("Users.json");
        for (int i = 0; i < users.size(); i++) {
            JSONObject user = (JSONObject) users.get(i);
            if (userId.equals(user.get("userId"))){
                userList.add(user);
            }
        }
        return userList;
    }

    public JSONArray getByRole(String role) {
        Utility utility = new Utility();
        JSONArray userList = new JSONArray();
        JSONArray users = utility.jsonArrayGenerator("Users.json");
        for (int i = 0; i < users.size(); i++) {
            JSONObject user = (JSONObject) users.get(i);
            if (role.equals(user.get("role"))){
                userList.add(user);
            }
        }
        return userList;
    }

    public JSONArray getAllUsers() {
        Utility utility = new Utility();
        JSONArray userList = new JSONArray();
        JSONArray users = utility.jsonArrayGenerator("Users.json");
        for (int i = 0; i < users.size(); i++){
            JSONObject user = (JSONObject) users.get(i);
            userList.add(user);
        }
        return userList;
    }
}