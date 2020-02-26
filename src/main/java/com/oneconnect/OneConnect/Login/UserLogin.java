package com.oneconnect.OneConnect.Login;

import java.util.List;

public class UserLogin {
    private String id;
    private List<String> roles;

    public UserLogin(String id, List<String> roles) {
        this.id = id;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
