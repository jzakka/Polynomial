package org.example;

public class Calculator extends Worker {
    public Calculator( Progress progress) {
        super("[\\+\\-\\*]", progress);
    }

    @Override
    public void work(String exp) {
        progress.calculate();
        progress.setOperator(exp.charAt(progress.getIdx()));
        progress.resetOperand();
    }
}
