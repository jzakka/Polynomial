package org.example;

public class Operand {
    long value;

    public long getValue() {
        return value;
    }

    public void appendDigit(char letter){
        value *= 10;
        value += letter-'0';
    }
}
