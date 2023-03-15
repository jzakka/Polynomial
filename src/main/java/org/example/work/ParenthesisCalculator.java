package org.example.work;

import org.example.*;

public class ParenthesisCalculator extends Worker {

    public ParenthesisCalculator() {
        super("\\(");
    }

    @Override
    public void work() {
        Register.setOperand(Evaluation.eval(Register.extractParenthesis()));
        Register.jump();
    }
}
