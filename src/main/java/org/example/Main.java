package org.example;

public class Main {
    public static void main(String[] args) {
        Integer i = 10;
        callByRef(i);
        System.out.println(i);
    }

    public static void callByRef(Integer integer){
        integer = integer + 10;
    }
}