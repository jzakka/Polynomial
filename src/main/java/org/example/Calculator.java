package org.example;

public class Calculator extends Worker {
    public Calculator() {
        super("[\\+\\-\\*]");
    }

    @Override
    public void work(String exp) {
        Progress.calculate();
        Progress.setOperator(exp.charAt(Progress.getIdx()));
        Progress.resetOperand();
    }
}
