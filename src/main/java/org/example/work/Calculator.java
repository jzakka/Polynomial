package org.example.work;

import org.example.Register;

public class Calculator extends Worker {
    public Calculator() {
        super("[\\+\\-\\*]");
    }

    @Override
    public void work() {
        Register.operate();
        Register.renewOperator();
        Register.resetOperand();
    }
}
