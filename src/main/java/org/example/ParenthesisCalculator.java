package org.example;

public class ParenthesisCalculator extends Worker {

    public ParenthesisCalculator(Progress progress) {
        super("\\(", progress);
    }

    @Override
    public void work(String exp) {
        progress.setOperand(new Evaluator().eval(exp.substring(progress.getIdx() + 1, exp.lastIndexOf(")"))));
        progress.jump(exp.lastIndexOf(")"));
    }
}
