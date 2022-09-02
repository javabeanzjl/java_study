package com.wuying.basis;

import org.junit.jupiter.api.Test;

public class Test03 {
    @Test
    public void test01() {
        int j = 5;
        for (int i = 0; i < 10; i++, j++) {
            if (j == 10) {
                System.out.println("for循环中居然能够这样写");
            }
        }
    }
    @Test
    public void test02() {
        int i = 0;
        int j = 3;
        LOOP: do {
            System.out.println("LOOP: " + i);
            i++;
            LOOP1: for (int m=0; m<j; m++){
                System.out.println("LOOP: " + m);
                // break LOOP1;  //跳出LOOP1循环
                break LOOP;  //跳出LOOP循环
            }
        } while(i<3);
    }
}
