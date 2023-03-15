package org.example.control;

import org.example.*;
import org.example.work.*;

import java.util.*;

public class Mediator {
    private static List<Worker> workers = new ArrayList<>();
    static {
        workers.add(new Appender());
        workers.add(new ParenthesisCalculator());
        workers.add(new Calculator());
    }

    public static void mediate(){
        for (Worker worker : workers) {
            worker.receiveWork();
        }
    }
}