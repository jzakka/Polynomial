package org.example;

import java.util.Stack;

public class Progress {
    private int idx = 0;
    private long res = 0l;
    private long prev = 0l;
    private char operator = '+';
    private long operand = 0;

    public static Progress currentStack;
    private static Stack<Progress> statusStack = new Stack<>();

    private Progress() {
    }

    public static void createStack(){
        statusStack.push(new Progress());
        currentStack = statusStack.peek();
    }

    public static void removeStack() {
        statusStack.pop();
        if (!statusStack.empty()) {
            currentStack = statusStack.peek();
        } else {
            currentStack = null;
        }
    }

    public static long getRes() {
        long result = currentStack.res;
        removeStack();
        return result;
    }

    public static void setOperator(char operator) {
        currentStack.operator = operator;
    }

    public static void setOperand(long operand) {
        currentStack.operand = operand;
    }

    public static void resetOperand() {
        setOperand(0);
    }

    public static void moveNext(){
        currentStack.idx++;
    }

    public static void jump(int dest){
        currentStack.idx = dest;
    }

    public static int getIdx() {
        return currentStack.idx;
    }

    public static void appendDigit(char letter) {
        currentStack.operand *= 10;
        currentStack.operand += letter -'0';
    }

    public static void add(){
        currentStack.res += currentStack.operand;
        currentStack.prev = currentStack.operand;
    }

    public static void sub(){
        currentStack.res -= currentStack.operand;
        currentStack.prev = -currentStack.operand;
    }

    public static void multiply(){
        currentStack.res = currentStack.res - currentStack.prev +
                currentStack.prev * currentStack.operand;
        currentStack.prev *= currentStack.operand;
    }

    public static void calculate() {
        switch (currentStack.operator) {
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
