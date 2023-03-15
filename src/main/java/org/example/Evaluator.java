package org.example;

import org.example.control.Mediator;

public class Evaluator {
    public long eval(String exp) {
        exp = exp.replaceAll(" ", "");
        Register.createStack(exp);

        while (Register.inExpression()) {
            Mediator.mediate();
            Register.moveNext();
        }
        Register.operate();

        return Register.getRes();
    }
}
