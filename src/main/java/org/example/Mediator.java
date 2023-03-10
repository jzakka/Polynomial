package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    int idx = 0;
    String exp;

    List<Worker> workers = new ArrayList<>();
    public Mediator(String exp) {
        this.exp = exp;

        workers.add(new Appender());
        workers.add(new ParenthesisCalculator());
        workers.add(new Calculator());
    }

    public void work(){
        for (Worker worker : workers) {
            worker.receiveWork(exp);
        }
        Progress.moveNext();
        idx++;
    }

    boolean inWorkPlace(){
        return Progress.getIdx() < exp.length();
    }
}