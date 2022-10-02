package com.wuying.basis;

import org.junit.jupiter.api.Test;

public class Test08 {
    static int age = 10;
    @Test
    public void test01() {
        // static int age = 10;// 静态变量只能在类中定义，不能在方法中定义
        test(13);
        doGet();
    }
    @SuppressWarnings("deprecation")
    public static void test(int age) {
        // java: 已在方法 test(int)中定义了变量 age
        // int age = 10;
        System.out.println(age);
    }
    @SuppressWarnings("deprecation")
    public static void doGet() {
        System.out.println(1 / 0);
    }
}
