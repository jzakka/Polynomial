package org.example.work;

import org.example.Progress;

public class Calculator extends Worker {
    public Calculator() {
        super("[\\+\\-\\*]");
    }

    @Override
    public void work() {
        Progress.operate();
        Progress.renewOperator();
        Progress.resetOperand();
    }
}
