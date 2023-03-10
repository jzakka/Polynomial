package org.example;

public class Evaluator {
    String exp;
    States currentStatus;
    public Evaluator(String exp) {
        this.exp = exp.replaceAll(" ", "");
        this.currentStatus  = new States();;
    }

    public long eval() {
        int i = 0;
        long operand = 0;
        while (i < exp.length()) {
            char letter = exp.charAt(i);
            if (Character.isDigit(letter)) {
                operand *= 10;
                operand += letter-'0';
            } else if (letter == '(') {
                operand= new Evaluator(exp.substring(i + 1, exp.lastIndexOf(")"))).eval();
                i = exp.lastIndexOf(")");
            } else {
                Calculator.calculate(currentStatus, operand);
                currentStatus.setOperator(letter);
                operand = 0;
            }
            i++;
        }
        Calculator.calculate(currentStatus, operand);
        return currentStatus.getRes();
    }


}
