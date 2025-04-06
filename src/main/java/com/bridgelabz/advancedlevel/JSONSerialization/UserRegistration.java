package com.bridgelabz.advancedlevel.JSONSerialization;

import java.lang.reflect.Field;

public class UserRegistration {
    public static String toJson(Object obj){
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        boolean firstField = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);

                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name();

                try {
                    Object value = field.get(obj);
                    if (!firstField) {
                        jsonBuilder.append(", ");
                    }
                    jsonBuilder.append("\"")
                            .append(jsonKey)
                            .append("\": \"")
                            .append(value)
                            .append("\"");
                    firstField = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    public static void main(String[] args) {
        User naman = new User("naman", "naman@gmail.com" , "naman123");
        System.out.println(toJson(naman));
    }
}
