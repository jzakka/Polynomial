package org.example.work;

import org.example.Register;

public class Calculator extends Worker {
    public Calculator() {
        super("[\\+\\-\\*]");
    }

    @Override
    public void work() {
        if (Register.signMinus()) {
            Register.negate();
            return;
        }
        Register.operate();
        Register.renewOperator();
        Register.resetOperand();
    }
}
