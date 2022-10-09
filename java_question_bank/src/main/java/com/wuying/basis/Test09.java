package com.wuying.basis;

import org.junit.jupiter.api.Test;

/**
 * 字符串拼接改变的数据本身。
 */
public class Test09 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a, b);
        System.out.println(a + "." + b);// AB.B
    }
    public static void operate(StringBuffer x, StringBuffer y) {
        // 直接修改对象本身，与数组一样
        x.append(y);
        // 赋值操作，改变地址
        y = x;
    }
    @Test
    public void test01() {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        System.out.println(a.hashCode());
        // System.out.println(a.append(b).hashCode());
        StringBuffer d = a;
        StringBuffer c = a.append(b);
        System.out.println(c.hashCode());
        System.out.println(a == c);// true
        System.out.println(d);
    }
}
