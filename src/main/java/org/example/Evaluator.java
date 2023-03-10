package org.example;

import java.util.Arrays;

public class Evaluator {
    String exp;
    char prevOp;
    long res;
    long prev;
    public Evaluator(String exp) {
        this.exp = exp.replaceAll(" ", "");
        this.prevOp = '+';
        this.res = 0l;
        this.prev = 0;
    }

    public long eval() {
        int i = 0;
        StringBuilder numStr = new StringBuilder();
        while (i < exp.length()) {
            char letter = exp.charAt(i);
            if (Character.isDigit(letter)) {
                numStr.append(exp.charAt(i));
            } else if(letter == '('){
                Long pathCalced = new Evaluator(exp.substring(i + 1, exp.lastIndexOf(")"))).eval();
                numStr = new StringBuilder(pathCalced.toString());
                i = exp.lastIndexOf(")");
            }
            else {
                calculate(numStr);
                prevOp = letter;
                numStr = new StringBuilder();
            }
            i++;
        }
        calculate(numStr);
        return res;
    }

    private void calculate(StringBuilder numStr) {
        long number = Long.parseLong(numStr.toString());
        switch (prevOp) {
            case '+':
                res += number;
                prev = number;
                break;
            case '-':
                res -= number;
                prev = -number;
                break;
            case '*':
                res = res - prev + prev * number;
                prev *= number;
                break;
            default:
                throw new RuntimeException();
        }
    }
}
