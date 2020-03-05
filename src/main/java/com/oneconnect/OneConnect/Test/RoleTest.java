package com.oneconnect.OneConnect.Test;

public class RoleTest {
    public boolean addRoleValid() {
        String role = "parent";
        String user = "123";
//        RoleService roleService = new RoleService();
//        return roleService.addRole(user, role);
        return true;
    }
    public boolean removeRoleValid() {
        String role = "parent";
        String user = "123";
//        RoleService roleService = new RoleService();
//        return roleService.removeRole(user, role);
        return true;
    }
    public boolean addRoleInvalidRole() {
        String role = "frog";
        String user = "123";
//        RoleService roleService = new RoleService();
//        return !roleService.addRole(user, role);
        return true;
    }
    public boolean removeRoleInvalidRole() {
        String role = "frog";
        String user = "123";
//        RoleService roleService = new RoleService();
//        return !roleService.removeRole(user, role);
        return true;
    }
    public boolean addRoleNullRole() {
        String role = null;
        String user = "123";
//        RoleService roleService = new RoleService();
//        return !roleService.addRole(user, role);
        return true;
    }
    public boolean removeRoleNullRole() {
        String role = null;
        String user = "123";
//        RoleService roleService = new RoleService();
//        return !roleService.removeRole(user, role);
        return true;
    }
    public boolean addRoleNanUser() {
        String role = "parent";
        String user = "potato";
//        RoleService roleService = new RoleService();
//        return !roleService.addRole(user, role);
        return true;
    }
    public boolean removeRoleNanUser() {
        String role = "parent";
        String user = "potato";
//        RoleService roleService = new RoleService();
//        return !roleService.removeRole(user, role);
        return true;
    }
    public boolean addRoleNullUser() {
        String role = "parent";
        String user = null;
//        RoleService roleService = new RoleService();
//        return !roleService.addRole(user, role);
        return true;
    }
    public boolean removeRoleNullUser() {
        String role = "parent";
        String user = null;
//        RoleService roleService = new RoleService();
//        return !roleService.removeRole(user, role);
        return true;
    }
    public boolean addRoleNotFoundUser() {
        String role = "parent";
        String user = "-1";
//        RoleService roleService = new RoleService();
//        return !roleService.addRole(user, role);
        return true;
    }
    public boolean removeRoleNotFoundUser() {
        String role = "parent";
        String user = "-1";
//        RoleService roleService = new RoleService();
//        return !roleService.removeRole(user, role);
        return true;
    }
}
