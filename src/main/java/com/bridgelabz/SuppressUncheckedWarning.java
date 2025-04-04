package com.bridgelabz;

import java.util.ArrayList;

public class SuppressUncheckedWarning {

    @SuppressWarnings("unchecked")
    public static void createUncheckedList(){
        ArrayList uncheckedList = new ArrayList();
        uncheckedList.add("Naman");
        uncheckedList.add(2003);
        uncheckedList.add(true);
        System.out.println(uncheckedList);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        System.out.println(list);

        createUncheckedList();

    }
}
