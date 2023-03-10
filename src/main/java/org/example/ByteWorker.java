package org.example;

public class ByteWorker{
    int idx = 0;
    String exp;

    public ByteWorker(String exp) {
        this.exp = exp;
    }

    public void makeOperand(States states){
        char letter = exp.charAt(idx);
        if (Character.isDigit(letter)) {
            states.appendDigit(letter);
        } else if (letter == '(') {
            states.setOperand(calculateParenthesis());
            jumpToEndOfParenthesis();
        } else {
            Calculator.calculate(states);
            states.setOperator(letter);
            states.resetOperand();
        }
        idx++;
    }

    private void jumpToEndOfParenthesis() {
        idx = exp.lastIndexOf(")");
    }

    private long calculateParenthesis() {
        return new Evaluator().eval(exp.substring(idx + 1, exp.lastIndexOf(")")));
    }

    boolean inWorkPlace(){
        return idx < exp.length();
    }
}