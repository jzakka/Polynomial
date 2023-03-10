package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    int idx = 0;
    String exp;
    Progress status;

    List<Worker> workers = new ArrayList<>();
    public Mediator(String exp, Progress status) {
        this.exp = exp;
        this.status = status;

        workers.add(new Appender(status));
        workers.add(new ParenthesisCalculator(status));
        workers.add(new Calculator(status));
    }

    public void work(){
        for (Worker worker : workers) {
            worker.receiveWork(exp);
        }
        status.moveNext();
        idx++;
    }

    boolean inWorkPlace(){
        return status.getIdx() < exp.length();
    }
}