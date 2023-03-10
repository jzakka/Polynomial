package org.example;

public class Progress {
    private int idx = 0;
    private long res = 0l;
    private long prev = 0l;
    private char operator = '+';
    private long operand = 0;

    public long getRes() {
        return res;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void setOperand(long operand) {
        this.operand = operand;
    }

    public void resetOperand() {
        setOperand(0);
    }

    public void moveNext(){
        idx++;
    }

    public void jump(int dest){
        idx = dest;
    }

    public int getIdx() {
        return idx;
    }

    public void appendDigit(char letter) {
        operand *= 10;
        operand += letter -'0';
    }

    public void add(){
        res += operand;
        prev = operand;
    }

    public void sub(){
        res -= operand;
        prev = -operand;
    }

    public void multiply(){
        res = res - prev + prev * operand;
        prev *= operand;
    }

    public void calculate() {
        switch (operator) {
            case '+':
                add();
                break;
            case '-':
                sub();
                break;
            case '*':
                multiply();
                break;
            default:
                throw new RuntimeException();
        }
    }
}
