package org.example;

public class Appender extends Worker {
    public Appender() {
        super("\\d");
    }

    @Override
    public void work(String exp) {
        char letter = exp.charAt(Progress.getIdx());
        Progress.appendDigit(letter);
    }
}
