package org.example.basis;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Test03 {
    // Scanner用法
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(str);
            }
            System.out.println();
        }
    }
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
    @Test
    public void test02() {
        char f = '发';
        System.out.println(f);
    }
}
