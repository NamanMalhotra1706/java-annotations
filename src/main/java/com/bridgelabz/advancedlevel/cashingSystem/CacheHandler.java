package com.bridgelabz.advancedlevel.cashingSystem;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheHandler {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invokeCached(Object obj, String methodName, Object... args) {
        try {
            Class<?> clazz = obj.getClass();
            Method method = clazz.getMethod(methodName, toClasses(args));

            if (method.isAnnotationPresent(CacheResult.class)) {
                String key = generateKey(methodName, args);

                if (cache.containsKey(key)) {
                    System.out.println("Returning cached result for " + key);
                    return cache.get(key);
                }

                Object result = method.invoke(obj, args);
                cache.put(key, result);
                return result;
            } else {
                return method.invoke(obj, args); // method not annotated
            }

        } catch (Exception e) {
            return null;
        }
    }

    private static Class<?>[] toClasses(Object[] args) {
        Class<?>[] classes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            classes[i] = args[i].getClass();
        }
        return classes;
    }

    private static String generateKey(String methodName, Object[] args) {
        StringBuilder key = new StringBuilder(methodName);
        for (Object arg : args) {
            key.append("_").append(arg.toString());
        }
        return key.toString();
    }

    public static void main(String[] args) {
        ExpensiveTask service = new ExpensiveTask();

        System.out.println("Result 1: " + CacheHandler.invokeCached(service, "SquareOfNumber", 5));
        System.out.println("Result 2: " + CacheHandler.invokeCached(service, "SquareOfNumber", 5));
        System.out.println("Result 3: " + CacheHandler.invokeCached(service, "SquareOfNumber", 7));
        System.out.println("Result 4: " + CacheHandler.invokeCached(service, "SquareOfNumber", 7));
    }
}
