package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {
    class Calc{
        public static long run(String exp){
            return new Evaluator().eval(exp);
        }
    }
    @Test
    @DisplayName("10 + 20 + 30 == 60")
    void t7() {
        assertThat(Calc.run("10 + 20 + 30")).isEqualTo(60);
    }

    @Test
    @DisplayName("10 * 20 - 20 * 30 == -400")
    void t18(){
        assertThat(Calc.run("10 * 20 - 20 * 30 ")).isEqualTo(-400);
    }

    @Test
    @DisplayName("20 + 10 + 5 * 2 == 40")
    void t16() {
        assertThat(Calc.run("20 + 10 + 5 * 2 ")).isEqualTo(40);
    }

    @Test
    @DisplayName("(10 + 20) == 30")
    void t19() {
        assertThat(Calc.run("(10 + 20)")).isEqualTo(30);
    }

    @Test
    @DisplayName("(20 + 20)*  20 == 800")
    void t20() {
        assertThat(Calc.run("(20 + 20)*  20")).isEqualTo(800);
    }

    @Test
    @DisplayName("(10 + 20) * 3 == 90")
    void t21() {
        assertThat(Calc.run("(10 + 20) * 3")).isEqualTo(90);
    }

    @Test
    @DisplayName("10 + (10 + 5) == 25")
    void t24() {
        assertThat(Calc.run("10 + (10 + 5)")).isEqualTo(25);
    }

    @Test
    void test1() {
        String exp = "0+1";
        assertThat(new Evaluator().eval(exp)).isEqualTo(1);
    }

    @Test
    void test2() {
        String exp = "7 + 3";
        assertThat(new Evaluator().eval(exp)).isEqualTo(10);
    }

    @Test
    void test3() {
        String exp = " 8+  9 +12";
        assertThat(new Evaluator().eval(exp)).isEqualTo(29);
    }

    @Test
    void test4() {
        String exp = " 8 - 6";
        assertThat(new Evaluator().eval(" 8 - 6")).isEqualTo(2);
    }

    @Test
    void test5(){
        String exp = "4 + 6*2";
        assertThat(new Evaluator().eval(exp)).isEqualTo(16);
    }

    @Test
    void test6(){
        String exp = "2*2* 2*3 + 3 - 7*8";
        assertThat(new Evaluator().eval(exp)).isEqualTo(-29);
    }

    @Test
    void test7(){
        String exp = "1 + 2+(3*(8+2)) -2";
        assertThat(new Evaluator().eval(exp)).isEqualTo(31);
    }

    @Test
    @DisplayName("1004 - ((7-9)*9 + 225-9*8)*1 == 869")
    void test8(){
        String exp = "1004 - ((7-9)*9 + 225-9*8)*1";
        assertThat(new Evaluator().eval(exp)).isEqualTo(869);
    }

    // 1004   - (-18 + 225 - 72) = 1004 -(225 - 90) = 1004 - 135 = 869
}