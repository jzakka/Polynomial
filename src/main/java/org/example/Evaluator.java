package org.example;

import org.example.control.Mediator;

public class Evaluator {
    Mediator mediator;
    public Evaluator() {
        mediator = new Mediator();
    }

    public long eval(String exp) {
        exp = exp.replaceAll(" ", "");
        Progress.createStack(exp);

        while (Progress.inExpression()) {
            mediator.mediate();
            Progress.moveNext();
        }
        Progress.operate();

        return Progress.getRes();
    }
}
