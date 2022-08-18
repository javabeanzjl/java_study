package com.example.common;

import org.junit.jupiter.api.Test;

public class Test01 {
    // && 和 || 的优先级
    @Test
    public void test01() {
        int a = 20;
        int b = 30;
        double c = 50;
        System.out.println(b / c);
        if (a < 30 && b < -5 || a > 10 && b > 10 == true) {
            System.out.println("测试");    
        }
    }
}
