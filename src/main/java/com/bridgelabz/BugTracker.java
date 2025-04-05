package com.bridgelabz;

import java.lang.reflect.Method;

public class BugTracker {


    @BugReport(description = "NullPointerException on login", assignedTo = "Naman")
    @BugReport(description = "UI glitch in dashboard", assignedTo = "NM")
    public void handleUserSession(){
        System.out.println("Handling user session...");
    }

    public static void main(String[] args) {
        try {
            Method method = BugTracker.class.getMethod("handleUserSession");

            // Get all BugReport annotations (repeatable)
            if (method.isAnnotationPresent(BugReports.class) || method.isAnnotationPresent(BugReport.class)) {
                BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

                System.out.println("Bug Reports for method: " + method.getName());
                for (BugReport bug : bugReports) {
                    System.out.println("Description: " + bug.description());
                    System.out.println("Assigned To: " + bug.assignedTo());
                    System.out.println();
                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
