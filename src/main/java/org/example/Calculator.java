package org.example;

public class Calculator extends Worker {
    public Calculator() {
        super("[\\+\\-\\*]");
    }

    @Override
    public void work() {
        Progress.calculate();
        Progress.renewOperator();
        Progress.resetOperand();
    }
}
