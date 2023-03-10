package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    List<Worker> workers = new ArrayList<>();
    public Mediator() {
        workers.add(new Appender());
        workers.add(new ParenthesisCalculator());
        workers.add(new Calculator());
    }

    public void mediate(){
        for (Worker worker : workers) {
            worker.receiveWork();
        }
        Progress.moveNext();
    }
}