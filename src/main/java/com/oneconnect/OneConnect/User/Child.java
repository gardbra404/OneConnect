package com.oneconnect.OneConnect.User;

public class Child {
    private String id;
    private String allowed;

    public Child(String id, String allowed) {
        this.id = id;
        this.allowed = allowed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAllowed() {
        return allowed;
    }

    public void setAllowed(String allowed) {
        this.allowed = allowed;
    }
}
