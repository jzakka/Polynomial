package org.example.work;

import org.example.Progress;

public class Appender extends Worker {
    public Appender() {
        super("\\d");
    }

    @Override
    public void work() {
        Progress.appendDigit();
    }
}
