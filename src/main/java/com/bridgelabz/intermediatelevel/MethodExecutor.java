package com.bridgelabz.intermediatelevel;

public class MethodExecutor {

    @LogExecutionTime
    public void HeavyTask() throws InterruptedException {
        long startTime = System.nanoTime();
        System.out.println("Program Started....");
        Thread.sleep(200);
        long enTime = System.nanoTime();

        System.out.println("Time taken to exceute program: " +(enTime-startTime));
    }
    public static void main(String[] args) throws InterruptedException {
        MethodExecutor methodExecutor = new MethodExecutor();

        methodExecutor.HeavyTask();
    }
}
