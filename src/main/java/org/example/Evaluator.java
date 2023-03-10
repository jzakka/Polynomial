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
        long operand = 0;
        while (i < exp.length()) {
            char letter = exp.charAt(i);
            if (Character.isDigit(letter)) {
                operand *= 10;
                operand += exp.charAt(i)-'0';
            } else if (letter == '(') {
                operand= new Evaluator(exp.substring(i + 1, exp.lastIndexOf(")"))).eval();
                i = exp.lastIndexOf(")");
            } else {
                calculate(operand);
                prevOp = letter;
                operand = 0;
            }
            i++;
        }
        calculate(operand);
        return res;
    }

    private void calculate(long number) {
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
