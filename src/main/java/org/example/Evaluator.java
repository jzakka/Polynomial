package org.example;

public class Evaluator {
    States currentStatus;
    public Evaluator() {
        this.currentStatus  = new States();;
    }

    public long eval(String exp) {
        exp = exp.replaceAll(" ", "");
        long operand = 0;
        ByteWorker byteWorker = new ByteWorker(exp);
        while (byteWorker.inWorkPlace()) {
            operand = byteWorker.work(operand, currentStatus);
        }
        Calculator.calculate(currentStatus, operand);
        return currentStatus.getRes();
    }


}
