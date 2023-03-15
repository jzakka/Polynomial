package org.example.work;

import org.example.Register;

public class Appender extends Worker {
    public Appender() {
        super("\\d");
    }

    @Override
    public void work() {
        Register.appendDigit();
    }
}
