package com.bridgelabz;

class LegacyAPI{
    @Deprecated
    public void oldFeature(){
        System.out.println("Deprecated function called ");
    }

    public void newFeature(){
        System.out.println("New Function called");
    }
}
public class DeprecatedAnnotation {

    public static void main(String[] args) {
        LegacyAPI legacyApi = new LegacyAPI();
        legacyApi.oldFeature();;
        legacyApi.newFeature();
    }
}