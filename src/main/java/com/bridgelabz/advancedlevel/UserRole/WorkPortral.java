package com.bridgelabz.advancedlevel.UserRole;

import java.lang.reflect.Method;

public class WorkPortral {
    public static void invokeMethodIfAllowed(Object obj, String methodName){
        Class<?> clazz = obj.getClass();

        if (clazz.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = clazz.getAnnotation(RoleAllowed.class);
            String requiredRole = roleAllowed.value();
            String currentRole = UserContext.getCurrentUserRole();

            if (!requiredRole.equalsIgnoreCase(currentRole)) {
                System.out.println("Access Denied to class '" + clazz.getSimpleName() + "' for role: " + currentRole);
                return;
            }
        }
        //  allowed, run the method
        try {
            Method method = clazz.getMethod(methodName);
            method.invoke(obj);
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        AdminServices services = new AdminServices();
        UserContext.setCurrentUserRole("USER");
        System.out.println("User LogIn");
        invokeMethodIfAllowed(services,"performAdminTask");


        //ADMIN
        UserContext.setCurrentUserRole("ADMIN");
        System.out.println("ADMIN Login");
        invokeMethodIfAllowed(services, "performAdminTask");
        invokeMethodIfAllowed(services, "anotherAdminTask");
    }
}
