package org.example;

import org.example.control.Mediator;

public class Evaluator {
    Mediator mediator;
    public Evaluator() {
        mediator = new Mediator();
    }

    public long eval(String exp) {
        exp = exp.replaceAll(" ", "");
        Register.createStack(exp);

        while (Register.inExpression()) {
            mediator.mediate();
            Register.moveNext();
        }
        Register.operate();

        return Register.getRes();
    }
}
