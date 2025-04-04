package com.bridgelabz;

class Animal{
    public void makeSound(){
        System.out.println("Animal make sound");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Bhau! Bhau!");
    }
}
public class OverrideAnnotation {
    public static void main(String[] args) {
        Dog tuffy = new Dog();
        tuffy.makeSound();

    }
}
