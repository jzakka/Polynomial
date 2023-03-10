package org.example;

public class Calculator {
    public static void calculate(States states, long number) {
        switch (states.getOperator()) {
            case '+':
                states.add(number);
                break;
            case '-':
                states.sub(number);
                break;
            case '*':
                states.multiply(number);
                break;
            default:
                throw new RuntimeException();
        }
    }
}
