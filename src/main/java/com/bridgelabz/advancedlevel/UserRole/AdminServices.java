package com.bridgelabz.advancedlevel.UserRole;

@RoleAllowed("ADMIN")
public class AdminServices {
    public void performAdminTask() {
        System.out.println("Admin task executed successfully.");
    }

    public void anotherAdminTask() {
        System.out.println("Another admin-only task executed.");
    }
}
