package com.wuying.basis;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

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
    // java中将ISO8859-1字符串转成GB2312编码
    @Test
    public void test03() {
        try {
            System.out.println(new String("字符串".getBytes("ISO8859-1"), "GB2312"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    // count = count++
    // 实际上是先将局部变量表中的0值放入操作数栈中，然后直接对局部变量表中的count进行自增，然后操作数栈中的
    // 0出栈赋值给了局部变量表中的count。最终表现为仍为0；
    @Test
    public void test04() {
        int count = 0;
        int num = 0;
        for (int i = 0; i < 100; i++) {
            num = num + i;
            count = count++;
            System.out.println(count);
        }
        System.out.println(num);
        System.out.println(count);
        System.out.println("num * count= " + (num * count));
    }
}
