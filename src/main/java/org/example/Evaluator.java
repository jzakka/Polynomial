package org.example;

public class Evaluator {
    String exp;
    States currentStatus;
    public Evaluator(String exp) {
        this.exp = exp.replaceAll(" ", "");
        this.currentStatus  = new States();;
    }

    public long eval() {
        long operand = 0;
        ByteWorker byteWorker = new ByteWorker(exp);
        while (byteWorker.inWorkPlace()) {
            operand = byteWorker.work(operand, currentStatus);
        }
        Calculator.calculate(currentStatus, operand);
        return currentStatus.getRes();
    }


}
