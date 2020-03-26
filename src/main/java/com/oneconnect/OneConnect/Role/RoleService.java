package com.oneconnect.OneConnect.Role;

import com.oneconnect.OneConnect.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RoleService {
    private boolean doesRoleExist(String role) {
        boolean exists = false;
        Utility utility = new Utility();
        JSONArray roles = utility.jsonArrayGenerator("Roles.json");
        for (int i = 0; i < roles.size(); i++) {
            if (((String)roles.get(i)).equals(role)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
    private boolean userHasRole(String id, String role) {
        boolean contains = false;
        Utility utility = new Utility();
        JSONArray users = utility.jsonArrayGenerator("Users.json");
        if (role != null && utility.numberChecker(id)) {
            for (int i = 0; i < users.size(); i++) {
                JSONObject user = (JSONObject) users.get(i);
                if (((String) user.get("id")).equals(id)) {
                    JSONArray userRoles = (JSONArray) user.get("role");
                    for (int j = 0; j < userRoles.size(); j++) {
                        if (role.equals(userRoles.get(j))) {
                            contains = true;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return contains;
    }

    public boolean addUserRole(String id, String role) {
        Utility utility = new Utility();
        boolean changed = false;
        System.out.println(utility.numberChecker(id) +" "+  doesRoleExist(role) +" "+ !userHasRole(id, role));
        if (utility.numberChecker(id) && doesRoleExist(role) && !userHasRole(id, role)) {
            JSONArray users = utility.jsonArrayGenerator("Users.json");
            JSONArray dupUsers = new JSONArray();
            for (int i = 0; i < users.size(); i++) {
                JSONObject user = (JSONObject) users.get(i);
                if (id.equals(user.get("id"))) {
                    JSONObject newUser = new JSONObject();
                    newUser.put("name", user.get("name"));
                    JSONArray roles = (JSONArray) user.get("role");
                    roles.add(role);
                    newUser.put("role", roles);
                    newUser.put("id", user.get("id"));
                    newUser.put("classes", user.get("classes"));
                    newUser.put("children", user.get("children"));
                    dupUsers.add(newUser);
                } else {
                    dupUsers.add(user);
                }
            }
            changed = utility.jsonWriter(dupUsers.toJSONString(), "Users.json");
        }
        return changed;
    }

    public boolean removeUserRole(String id, String role) {
        Utility utility = new Utility();
        boolean changed = false;
        if (utility.numberChecker(id) && doesRoleExist(role) && userHasRole(id, role)) {
            JSONArray users = utility.jsonArrayGenerator("Users.json");
            JSONArray dupUsers = new JSONArray();
            for (int i = 0; i < users.size(); i++) {
                JSONObject user = (JSONObject) users.get(i);
                if (id.equals(user.get("id"))) {
                    JSONObject newUser = new JSONObject();
                    newUser.put("name", user.get("name"));
                    JSONArray roles = (JSONArray) user.get("role");
                    JSONArray dupRoles = new JSONArray();
                    for (int j = 0; j < roles.size(); j++) {
                        if (!roles.get(j).equals(role)) {
                            dupRoles.add(roles.get(j));
                        }
                    }
                    newUser.put("role", dupRoles);
                    newUser.put("id", user.get("id"));
                    newUser.put("classes", user.get("classes"));
                    newUser.put("children", user.get("children"));
                    dupUsers.add(newUser);
                } else {
                    dupUsers.add(user);
                }
            }
            changed = utility.jsonWriter(dupUsers.toJSONString(), "Users.json");
        }
        return changed;
    }
    @SuppressWarnings("Duplicated")
    public List<String> getUserRoles(String id) {
        Utility utility = new Utility();
        List<String> roles = new ArrayList<>();
        if (utility.numberChecker(id)) {
            JSONArray users = utility.jsonArrayGenerator("Users.json");
            for (int i = 0; i < users.size(); i++) {
                JSONObject user = (JSONObject) users.get(i);
                if (user.get("id").equals(id)) {
                    JSONArray userRoles = (JSONArray) user.get("role");
                    for (int j = 0; j < userRoles.size(); j++) {
                        roles.add((String) userRoles.get(j));
                    }
                    break;
                }
            }
        }
        return roles;
    }

    public List<String> getOtherRoles(String id) {
        Utility utility = new Utility();
        List<String> dupRoles = new ArrayList<>();
        if (utility.numberChecker(id)) {
            List<String> userRoles = getUserRoles(id);
            List<String> roles = utility.convertJsonArray(utility.jsonArrayGenerator("Roles.json"));
            for (String role: roles) {
                if (!userRoles.contains(role)) {
                    dupRoles.add(role);
                }
            }

        }
        return dupRoles;
    }
}
