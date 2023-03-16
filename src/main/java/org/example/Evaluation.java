package org.example;

import org.example.control.Mediator;

public class Evaluation {
    public static long eval(String exp) {
        exp = exp.replaceAll(" ", "");
        Register.createStack(exp);

        while (Register.inExpression()) {
            Mediator.mediate();
            Register.pointNext();
        }
        Register.operate();

        return Register.getRes();
    }
}
