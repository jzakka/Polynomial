package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Progress {
    private String exp;
    private int idx = 0;
    private long res = 0l;
    private long prev = 0l;
    private char operator = '+';
    private long operand = 0;

    public static Progress currentStack;
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

    public static String getExpression() {
        return currentStack.exp;
    }

    public static Character getCurrentDigit() {
        return getExpression().charAt(getIdx());
    }

    public static boolean inExpression(){
        return currentStack.idx < getExpression().length();
    }

    public static long getRes() {
        long result = currentStack.res;
        removeStack();
        return result;
    }

    public static void renewOperator() {
        currentStack.operator = getExpression().charAt(getIdx());
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

    public static String extractParenthesis(){
        return getExpression().substring(Progress.getIdx() + 1, lastIndexOfRightParenthesis());
    }

    public static void jump() {
        currentStack.idx = lastIndexOfRightParenthesis();
    }

    public static int lastIndexOfRightParenthesis(){
        return getExpression().lastIndexOf(")");
    }

    public static int getIdx() {
        return currentStack.idx;
    }

    public static void appendDigit() {
        char letter = getExpression().charAt(currentStack.idx);
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

    public static void mul(){
        currentStack.res = currentStack.res - currentStack.prev +
                currentStack.prev * currentStack.operand;
        currentStack.prev *= currentStack.operand;
    }

    public static void calculate() {
        operations.get(currentStack.operator).run();
    }
}
