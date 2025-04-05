package com.bridgelabz.beginnerlevel;
import com.bridgelabz.beginnerlevel.Todo;

import java.lang.reflect.Method;

public class TodoManager {

    @Todo(status = "Completed", taskDescription = "Personal To-Do List", assignedTo = "Naman", priority = "Low")
    public void groceryShopping(){
        System.out.println("Buy milk, eggs, bread, and cheese");
    }

    @Todo(taskDescription = "Personal To-Do List", assignedTo = "NM", priority = "MEDIUM")
    public void Errands(){
        System.out.println("Pay bills online");
    }

    @Todo(taskDescription = "Work To-Do List" , assignedTo = "NMG", priority = "HIGH")
    public void MeetingWithClient(){
        System.out.println("Review the contract");
    }


    public static void main(String[] args) {
        Class<TodoManager> clazz = TodoManager.class;
        Method[] methods = clazz.getMethods();

        
        for(Method method : methods){
            if (method.isAnnotationPresent(Todo.class) ) {
                Todo todo = method.getAnnotation(Todo.class);
                if (!todo.status().equals("Completed")) {
                    System.out.println("Method: " + method.getName());
                    System.out.println("Todo Status: " + todo.status());
                    System.out.println("Todo description: " + todo.taskDescription());
                    System.out.println("Todo Priority: " + todo.priority());
                    System.out.println("Assigned to: " + todo.assignedTo());
                    System.out.println();
                }
            }
        }
    }
}
