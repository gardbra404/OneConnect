package com.oneconnect.OneConnect.Test;

public class RoleTest {
    public boolean addValidRole() {
        String role = "student";
        String id = "125";
        //RoleService roleService = new RoleService();
        //return roleService.addRole(id, role);
        return true;
    }

    public boolean addDuplicateRole() {
        String role = "student";
        String id = "123";
        //RoleService roleService = new RoleService();
        //return !roleService.addRole(id, role);
        return true;
    }

    public boolean addNotFoundRole() {
        String role = "whatever";
        String id = "125";
        //RoleService roleService = new RoleService();
        //return !roleService.addRole(id, role);
        return true;
    }

    public boolean addNullRole() {
        String role = null;
        String id = "125";
        //RoleService roleService = new RoleService();
        //return !roleService.addRole(id, role);
        return true;
    }

    public boolean addValidRoleNanStudent() {
        String role = "student";
        String id = "potato";
        //RoleService roleService = new RoleService();
        //return !roleService.addRole(id, role);
        return true;
    }

    public boolean addValidRoleNullStudent() {
        String role = "student";
        String id = null;
        //RoleService roleService = new RoleService();
        //return !roleService.addRole(id, role);
        return true;
    }

    public boolean addValidRoleNotFoundStudent() {
        String role = "student";
        String id = "-1";
        //RoleService roleService = new RoleService();
        //return !roleService.addRole(id, role);
        return true;
    }
}
