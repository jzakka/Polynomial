package org.example;

public class Evaluator {
    States currentStatus;
    ByteWorker byteWorker;
    public Evaluator() {
        this.currentStatus  = new States();;
    }

    public long eval(String exp) {
        byteWorker = new ByteWorker(exp.replaceAll(" ", ""));
        while (byteWorker.inWorkPlace()) {
            byteWorker.makeOperand(currentStatus);
        }
        Calculator.calculate(currentStatus);
        return currentStatus.getRes();
    }
}
