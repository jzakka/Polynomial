package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(String.valueOf('1').matches("\\d"));
    }

    public static void callByRef(Integer integer){
        integer = integer + 10;
    }
}