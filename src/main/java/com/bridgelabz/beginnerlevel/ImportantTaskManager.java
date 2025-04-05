package com.bridgelabz.beginnerlevel;

import java.lang.reflect.Method;

public class ImportantTaskManager {

    @ImportantMethod(level = "LOW")
    public void Task1(){
        System.out.println("Task 1");
    }

    @ImportantMethod(level = "MEDIUM")
    public void Task2(){
        System.out.println("Task 2");
    }

    @ImportantMethod()
    public void Task3(){
        System.out.println("Task 3");
    }


    public static void main(String[] args) {
        Class<ImportantTaskManager> clazz = ImportantTaskManager.class;

        Method[] methods = clazz.getMethods();

        for(Method method : methods){
            if(method.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: "+importantMethod.level());
                System.out.println();
            }
        }
    }
}
