package org.example;

public class Calculator {
    public static void calculate(States states, char prevOp, long number) {
        switch (prevOp) {
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
