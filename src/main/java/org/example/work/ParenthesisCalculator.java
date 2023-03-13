package org.example.work;

import org.example.*;

public class ParenthesisCalculator extends Worker {

    public ParenthesisCalculator() {
        super("\\(");
    }

    @Override
    public void work() {
        Progress.setOperand(new Evaluator().eval(Progress.extractParenthesis()));
        Progress.jump();
    }
}
