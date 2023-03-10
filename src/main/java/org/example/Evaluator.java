package org.example;

public class Evaluator {
    Mediator mediator;
    public Evaluator() {}

    public long eval(String exp) {
        exp = exp.replaceAll(" ", "");
        Progress.createStack(exp);
        mediator = new Mediator();
        while (Progress.inExpression()) {
            mediator.mediate();
        }
        Progress.calculate();
        return Progress.getRes();
    }
}
