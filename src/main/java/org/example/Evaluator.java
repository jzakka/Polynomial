package org.example;

public class Evaluator {
    Progress currentStatus;
    Mediator byteWorker;
    public Evaluator() {
        this.currentStatus  = new Progress();;
    }

    public long eval(String exp) {
        byteWorker = new Mediator(exp.replaceAll(" ", ""), currentStatus);
        while (byteWorker.inWorkPlace()) {
            byteWorker.work();
        }
        currentStatus.calculate();
        return currentStatus.getRes();
    }
}
