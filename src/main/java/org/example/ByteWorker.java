package org.example;

public class ByteWorker{
    int idx = 0;
    String exp;

    public ByteWorker(String exp) {
        this.exp = exp;
    }

    public long work( long operand, States states){
        char letter = exp.charAt(idx);
        if (Character.isDigit(letter)) {
            operand *= 10;
            operand += letter-'0';
        } else if (letter == '(') {
            operand= new Evaluator(exp.substring(idx + 1, exp.lastIndexOf(")"))).eval();
            idx = exp.lastIndexOf(")");
        } else {
            Calculator.calculate(states, operand);
            states.setOperator(letter);
            operand = 0; //
        }
        idx++;
        return operand;
    }

    boolean inWorkPlace(){
        return idx < exp.length();
    }
}