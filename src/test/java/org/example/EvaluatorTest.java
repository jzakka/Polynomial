package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {
    class Calc{
        public static long run(String exp){
            return new Evaluator(exp).eval();
        }
    }
    @Test
    @DisplayName("10 + 20 + 30 == 60")
    void t7() {
        assertThat(Calc.run("10 + 20 + 30")).isEqualTo(60);
    }
    @Test
    void test1() {
        assertThat(new Evaluator("0+1").eval()).isEqualTo(1);
    }

    @Test
    void test2() {
        assertThat(new Evaluator("7 + 3").eval()).isEqualTo(10);
    }

    @Test
    void test3() {
        assertThat(new Evaluator(" 8+  9 +12").eval()).isEqualTo(29);
    }

    @Test
    void test4() {
        assertThat(new Evaluator(" 8 - 6").eval()).isEqualTo(2);
    }

    @Test
    void test5(){
        assertThat(new Evaluator("4 + 6*2").eval()).isEqualTo(16);
    }

    @Test
    void test6(){
        assertThat(new Evaluator("2*2* 2*3 + 3 - 7*8").eval()).isEqualTo(-29);
    }

    @Test
    void test7(){
        assertThat(new Evaluator("1 + 2+(3*(8+2)) -2").eval()).isEqualTo(31);
    }

    @Test
    void test8(){
        assertThat(new Evaluator("1004 - ((7-9)*9 + 225-9*8)*1").eval()).isEqualTo(869);
    }

    // 1004   - (-18 + 225 - 72) = 1004 -(225 - 90) = 1004 - 135 = 869
}