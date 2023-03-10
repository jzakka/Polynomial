package org.example;

public class Evaluator {
    Mediator byteWorker;
    public Evaluator() {}

    public long eval(String exp) {
        Progress.createStack();
        byteWorker = new Mediator(exp.replaceAll(" ", ""));
        while (byteWorker.inWorkPlace()) {
            byteWorker.work();
        }
        Progress.calculate();
        return Progress.getRes();
    }
}
