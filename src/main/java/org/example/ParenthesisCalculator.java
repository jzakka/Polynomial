package org.example;

public class ParenthesisCalculator extends Worker {

    public ParenthesisCalculator() {
        super("\\(");
    }

    @Override
    public void work(String exp) {
        Progress.setOperand(new Evaluator().eval(exp.substring(Progress.getIdx() + 1, exp.lastIndexOf(")"))));
        Progress.jump(exp.lastIndexOf(")"));
    }
}
