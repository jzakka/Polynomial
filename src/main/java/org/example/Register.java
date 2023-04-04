package org.example;

import java.util.*;

public class Register {
    private String exp;
    private int idx = 0;
    private long res = 0l;

    //Previous calculated degree's value;
    private long prev = 0l;
    private char operator = '+';
    private long operand = 0;
    private boolean negateOperand = false;
    private int jumpIdx;
    private static Stack<Integer> parenthesisPos = new Stack<>();

    public static Register currentStatus;
    private static Stack<Register> statusStack = new Stack<>();

    private static Map<Character, Runnable> operations = new HashMap<>();

    static {
        operations.put('+', Register::add);
        operations.put('-', Register::minus);
        operations.put('*', Register::mul);
    }

    private Register(String exp) {
        this.exp = exp;
    }

    public static void createStack(String exp){
        statusStack.push(new Register(exp));
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

    public static int getJumpIdx(){
        return currentStatus.jumpIdx;
    }

    public static void setJumpIdx(int idx){
        currentStatus.jumpIdx = idx;
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

    public static void pointNext(){
        currentStatus.idx++;
    }

    public static String extractParenthesis() {
        Stack<Byte> pair = new Stack<>();
        int i;
        for (i = Register.getIdx(); i < getExpression().length(); i++) {
            char digit = getExpression().charAt(i);
            if (digit == '(') {
                pair.push((byte) 1);
            } else if (digit == ')') {
                pair.pop();
                if (pair.empty()) {
                    break;
                }
            }
        }
        setJumpIdx(i);
        return getExpression().substring(Register.getIdx() + 1, i);
    }

    public static void jump() {
        currentStatus.idx = getJumpIdx();
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
        currentStatus.negateOperand = false;
    }

    public static void minus(){
        sub();
    }

    private static void sub() {
        currentStatus.res -= currentStatus.operand;
        currentStatus.prev = -currentStatus.operand;
        currentStatus.negateOperand = false;
    }

    public static void mul(){
        //Undo previous operation and add multiplied value
        currentStatus.res = currentStatus.res - currentStatus.prev + currentStatus.prev * currentStatus.operand;
        currentStatus.prev *= currentStatus.operand;
        currentStatus.negateOperand = false;
    }

    public static void operate() {
        if (currentStatus.negateOperand) {
            currentStatus.operand *= -1;
        }
        operations.get(currentStatus.operator).run();
    }

    public static boolean signMinus() {
        return currentStatus.idx > 0 && "-+*".contains(String.valueOf(currentStatus.exp.charAt(currentStatus.idx - 1)));
    }


    public static void negate() {
        currentStatus.negateOperand = true;
    }
}
