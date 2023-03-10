package org.example;

public class States {
    private long res = 0l;
    private long prev = 0l;
    private char operator = '+';

    public long getRes() {
        return res;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void add(long number){
        res += number;
        prev = number;
    }

    public void sub(long number){
        res -= number;
        prev = -number;
    }

    public void multiply(long number){
        res = res - prev + prev * number;
        prev *= number;
    }
}
