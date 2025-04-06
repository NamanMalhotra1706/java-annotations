package com.bridgelabz.advancedlevel.cashingSystem;

public class ExpensiveTask {

    @CacheResult
    public int SquareOfNumber(Integer number){
        System.out.println("Computing square for: " + number);

        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        return number*number;
    }
}
