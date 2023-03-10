package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {

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
}