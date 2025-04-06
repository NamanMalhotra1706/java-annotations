package com.bridgelabz.advancedlevel.UserRole;

public class UserContext {
    private static String currentUserRole;

    public static void setCurrentUserRole(String role){
        currentUserRole = role;
    }

    public static String getCurrentUserRole(){
        return currentUserRole;
    }
}
