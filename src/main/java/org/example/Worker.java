package org.example;

public abstract class Worker {
    String conditionalRegex;

    public Worker(String conditionalRegex) {
        this.conditionalRegex = conditionalRegex;
    }

    public void receiveWork(String exp){
        char letter = exp.charAt(Progress.getIdx());
        if (String.valueOf(letter).matches(conditionalRegex)) {
            work(exp);
        }
    }

    public abstract void work(String exp);
}
