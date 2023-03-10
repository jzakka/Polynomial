package org.example;

public class Calculator {
    public static void calculate(States states) {
        switch (states.getOperator()) {
            case '+':
                states.add();
                break;
            case '-':
                states.sub();
                break;
            case '*':
                states.multiply();
                break;
            default:
                throw new RuntimeException();
        }
    }
}
