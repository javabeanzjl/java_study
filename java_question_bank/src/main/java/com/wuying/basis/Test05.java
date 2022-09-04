package com.wuying.basis;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class Test05 {
    /**
     * 测试replace方法
     */
    @Test
    public void test01() {
        String str = "www.baidu.com";
        System.out.println(str.replaceAll(".","/"));// 输出/////////////
        // 原因：replaceAll方法的第一个参数是正则表达式，而"."在正则中表示任何字符。所以会全部替换
        System.out.println(str.replaceAll("\\.","/"));// www/baidu/com
    }
    /**
     * 如何让x等于1且让x等于2且让x等于3等式成立？
     */
    
    @BeforeAll
    public void before() {
        AtomicInteger value = new AtomicInteger();
    }
    @Test
    public void test02() {
        int x = 1;
        
        if (x == 1 && x==2) {
            System.out.println("22");
        }
        System.out.println();
    }
    
    @Test
    public void test05() {
        int x = X.val;
        do {
            x = newX();
            System.out.println(x);
        } while ((x != 3));
        /*if (newX()==1 && newX() == 2 && newX() == 3) {
            System.out.println("success");    
        }*/
        
    }
    public static int newX() {
        String str = String.valueOf(new X());
        Integer x = Integer.valueOf(str);
        return x;
    }
}
class A {
    public A() {
        Test05.newX();
    }
}
class X {
    public static int val = 0;
    public X() {
    }

    @Override
    public String toString() {
        val++;
        return String.valueOf(val);
    }
}
