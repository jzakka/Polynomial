package org.example;

public class Appender extends Worker {
    public Appender() {
        super("\\d");
    }

    @Override
    public void work() {
        Progress.appendDigit();
    }
}
