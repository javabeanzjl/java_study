package com.wuying.basis;

import org.junit.jupiter.api.Test;

/**
 * 创建了几个对象
 */
public class Test10 {

    /**
     * 实际上只有一个对象，因为字符串直接量+运算符拼接在编译器阶段就已经完成了，得到abcbc124这个字符串
     * 并将这个常量放到字符串池中了。
     * 但是！！！
     * 如果是+运算符拼接的字符串引用，那么就会创建多个对象
     */
    @Test
    public void test01() {
        String s = "abc" + "bc" + 124;// 1个对象
        String a = "abc";
        String b = "bc";
        String c = "124";
        String d = a + b + c;// 这样就是4个对象
        System.out.println(s == d);// false;
        System.out.println(s);
        System.out.println(d);
        
    }
}
