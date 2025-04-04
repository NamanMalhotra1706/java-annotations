package com.bridgelabz;

import java.lang.reflect.Method;

public class TaskManager {
    @TaskInfo(priority = "Low", assignedTo = "Naman")
    public void completeReport() {
        System.out.println("Completing report...");
    }

    @TaskInfo(priority = "High", assignedTo = "NM")
    public void replyToEmails() {
        System.out.println("Replying to emails...");
    }

    public void coffeeBreak() {
        System.out.println("Taking a coffee break...");
    }

    public static void main(String[] args) {
        Class<TaskManager> clazz = TaskManager.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods){
            if(method.isAnnotationPresent(TaskInfo.class)){
                TaskInfo info = method.getAnnotation(TaskInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority   : " + info.priority());
                System.out.println("Assigned To: " + info.assignedTo());
                System.out.println();
            }
        }
    }
}
