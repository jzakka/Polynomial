package org.example;

public class ByteWorker{
    int idx = 0;
    long operand = 0;
    String exp;

    public ByteWorker(String exp) {
        this.exp = exp;
    }

    public long getOperand() {
        return operand;
    }

    public long work(States states){
        char letter = exp.charAt(idx);
        if (Character.isDigit(letter)) {
            operand = appendDigit(operand, letter);
        } else if (letter == '(') {
            operand= calculateParenthesis();
            idx = exp.lastIndexOf(")");
        } else {
            Calculator.calculate(states, operand);
            states.setOperator(letter);
            operand = 0;
        }
        idx++;
        return operand;
    }

    private long appendDigit(long operand, char letter) {
        operand *= 10;
        operand += letter -'0';
        return operand;
    }

    private long calculateParenthesis() {
        return new Evaluator().eval(exp.substring(idx + 1, exp.lastIndexOf(")")));
    }

    boolean inWorkPlace(){
        return idx < exp.length();
    }
}