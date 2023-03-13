package org.example;

import java.util.*;

public class Progress {
    private String exp;
    private int idx = 0;
    private long res = 0l;

    //Previous calculated degree's value;
    private long prev = 0l;
    private char operator = '+';
    private long operand = 0;

    public static Progress currentStatus;
    private static Stack<Progress> statusStack = new Stack<>();

    private static Map<Character, Runnable> operations = new HashMap<>();

    static {
        operations.put('+', Progress::add);
        operations.put('-', Progress::sub);
        operations.put('*', Progress::mul);
    }

    private Progress(String exp) {
        this.exp = exp;
    }

    public static void createStack(String exp){
        statusStack.push(new Progress(exp));
        currentStatus = statusStack.peek();
    }

    public static void removeStack() {
        statusStack.pop();
        if (!statusStack.empty()) {
            currentStatus = statusStack.peek();
        }
    }

    public static String getExpression() {
        return currentStatus.exp;
    }

    public static Character getCurrentDigit() {
        return getExpression().charAt(getIdx());
    }

    public static boolean inExpression(){
        return currentStatus.idx < getExpression().length();
    }

    public static long getRes() {
        long result = currentStatus.res;
        removeStack();
        return result;
    }

    public static void renewOperator() {
        currentStatus.operator = getExpression().charAt(getIdx());
    }

    public static void setOperand(long operand) {
        currentStatus.operand = operand;
    }

    public static void resetOperand() {
        setOperand(0);
    }

    public static void moveNext(){
        currentStatus.idx++;
    }

    public static String extractParenthesis(){
        return getExpression().substring(Progress.getIdx() + 1, lastIndexOfRightParenthesis());
    }

    public static void jump() {
        currentStatus.idx = lastIndexOfRightParenthesis();
    }

    public static int lastIndexOfRightParenthesis(){
        return getExpression().lastIndexOf(")");
    }

    public static int getIdx() {
        return currentStatus.idx;
    }

    public static void appendDigit() {
        char letter = getExpression().charAt(currentStatus.idx);
        currentStatus.operand *= 10;
        currentStatus.operand += letter -'0';
    }

    public static void add(){
        currentStatus.res += currentStatus.operand;
        currentStatus.prev = currentStatus.operand;
    }

    public static void sub(){
        currentStatus.res -= currentStatus.operand;
        currentStatus.prev = -currentStatus.operand;
    }

    public static void mul(){
        //Undo previous operation and add multiplied value
        currentStatus.res = currentStatus.res - currentStatus.prev +
                currentStatus.prev * currentStatus.operand;
        currentStatus.prev *= currentStatus.operand;
    }

    public static void operate() {
        operations.get(currentStatus.operator).run();
    }
}
