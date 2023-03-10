package org.example;

public abstract class Worker {
    String conditionalRegex;
    Progress progress;

    public Worker(String conditionalRegex, Progress progress) {
        this.conditionalRegex = conditionalRegex;
        this.progress = progress;
    }

    public void receiveWork(String exp){
        char letter = exp.charAt(progress.getIdx());
        if (String.valueOf(letter).matches(conditionalRegex)) {
            work(exp);
        }
    }

    public abstract void work(String exp);
}
