package org.example;

public class Appender extends Worker {
    public Appender(Progress progress) {
        super("\\d", progress);
    }

    @Override
    public void work(String exp) {
        char letter = exp.charAt(progress.getIdx());
        progress.appendDigit(letter);
    }
}
