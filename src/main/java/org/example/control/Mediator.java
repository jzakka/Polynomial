package org.example.control;

import org.example.*;
import org.example.work.Appender;
import org.example.work.Calculator;
import org.example.work.ParenthesisCalculator;
import org.example.work.Worker;

import java.util.*;

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