package com.oneconnect.OneConnect.UserCreation;

public class Child {
    public String userId;
    public String allowed;

    public Child(String userId, String allowed) {
        this.userId = userId;
        this.allowed = allowed;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAllowed() {
        return allowed;
    }

    public void setAllowed(String allowed) {
        this.allowed = allowed;
    }
}
