package org.example;

public class Evaluator {
    States currentStatus;
    public Evaluator() {
        this.currentStatus  = new States();;
    }

    public long eval(String exp) {
        exp = exp.replaceAll(" ", "");
        ByteWorker byteWorker = new ByteWorker(exp);
        while (byteWorker.inWorkPlace()) {
            byteWorker.work(currentStatus);
        }
        Calculator.calculate(currentStatus, byteWorker.getOperand());
        return currentStatus.getRes();
    }


}
