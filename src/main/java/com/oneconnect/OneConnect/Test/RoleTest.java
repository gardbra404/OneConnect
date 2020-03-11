package com.oneconnect.OneConnect.Test;

import com.oneconnect.OneConnect.Role.RoleService;

public class RoleTest {
    public boolean addUserRoleValid() {
        String role = "parent";
        String user = "123";
        RoleService roleService = new RoleService();
        return roleService.addUserRole(user, role);
        
    }
    public boolean removeUserRoleValid() {
        String role = "parent";
        String user = "123";
        RoleService roleService = new RoleService();
        return roleService.removeUserRole(user, role);
        
    }
    public boolean addUserRoleDuplicateRole() {
        String role = "admin";
        String user = "123";
        RoleService roleService = new RoleService();
        return !roleService.addUserRole(user, role);
        
    }
    public boolean removeUserRoleNotHeld() {
        String role = "teacher";
        String user = "123";
        RoleService roleService = new RoleService();
        return !roleService.removeUserRole(user, role);
        
    }
    public boolean addUserRoleInvalidRole() {
        String role = "frog";
        String user = "123";
        RoleService roleService = new RoleService();
        return !roleService.addUserRole(user, role);
        
    }
    public boolean removeUserRoleInvalidRole() {
        String role = "frog";
        String user = "123";
        RoleService roleService = new RoleService();
        return !roleService.removeUserRole(user, role);
        
    }
    public boolean addUserRoleNullRole() {
        String role = null;
        String user = "123";
        RoleService roleService = new RoleService();
        return !roleService.addUserRole(user, role);
        
    }
    public boolean removeUserRoleNullRole() {
        String role = null;
        String user = "123";
        RoleService roleService = new RoleService();
        return !roleService.removeUserRole(user, role);
        
    }
    public boolean addUserRoleNanUser() {
        String role = "parent";
        String user = "potato";
        RoleService roleService = new RoleService();
        return !roleService.addUserRole(user, role);
        
    }
    public boolean removeUserRoleNanUser() {
        String role = "parent";
        String user = "potato";
        RoleService roleService = new RoleService();
        return !roleService.removeUserRole(user, role);
        
    }
    public boolean addUserRoleNullUser() {
        String role = "parent";
        String user = null;
        RoleService roleService = new RoleService();
        return !roleService.addUserRole(user, role);
        
    }
    public boolean removeUserRoleNullUser() {
        String role = "parent";
        String user = null;
        RoleService roleService = new RoleService();
        return !roleService.removeUserRole(user, role);
        
    }
    public boolean addUserRoleNotFoundUser() {
        String role = "parent";
        String user = "-1";
        RoleService roleService = new RoleService();
        return !roleService.addUserRole(user, role);
        
    }
    public boolean removeUserRoleNotFoundUser() {
        String role = "parent";
        String user = "-1";
        RoleService roleService = new RoleService();
        return !roleService.removeUserRole(user, role);
        
    }

    public String runTests() {
        return "<br/><br/>Role Management Test:"
                +"<br/>addUserRoleValid: " + (addUserRoleValid() ? "Passed" : "Failed")
                +"<br/>removeUserRoleValid: " + (removeUserRoleValid() ? "Passed" : "Failed")
                +"<br/>addUserRoleDuplicateRole: " + (addUserRoleDuplicateRole() ? "Passed" : "Failed")
                +"<br/>removeUserRoleNotHeld: " + (removeUserRoleNotHeld() ? "Passed" : "Failed")
                +"<br/>addUserRoleInvalidRole: " + (addUserRoleInvalidRole() ? "Passed" : "Failed")
                +"<br/>removeUserRoleInvalidRole: " + (removeUserRoleInvalidRole() ? "Passed" : "Failed")
                +"<br/>addUserRoleNullRole: " + (addUserRoleNullRole() ? "Passed" : "Failed")
                +"<br/>removeUserRoleNullRole: " + (removeUserRoleNullRole() ? "Passed" : "Failed")
                +"<br/>addUserRoleNanUser: " + (addUserRoleNanUser() ? "Passed" : "Failed")
                +"<br/>removeUserRoleNanUser: " + (removeUserRoleNanUser() ? "Passed" : "Failed")
                +"<br/>addUserRoleNullUser: " + (addUserRoleNullUser() ? "Passed" : "Failed")
                +"<br/>removeUserRoleNullUser: " + (removeUserRoleNullUser() ? "Passed" : "Failed")
                +"<br/>addUserRoleNotFoundUser: " + (addUserRoleNotFoundUser() ? "Passed" : "Failed")
                +"<br/>removeUserRoleNotFoundUser: " + (removeUserRoleNotFoundUser() ? "Passed" : "Failed");
    }
}