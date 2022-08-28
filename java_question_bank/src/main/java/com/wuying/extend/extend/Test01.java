package com.wuying.extend.extend;

import org.junit.jupiter.api.Test;

public class Test01 extends Test02{
    /**
     * 碰见
     */
    @Test
    public void test01() {
        String name = "zhangsan";
        Object obj = name;
        Test02 test02 = new Test01();
        test02.one("zhangsan");
        one(name);
        one(obj);
        two(name);
        two(obj);
    }
    public static void one(String name) {
        System.out.println("01s" + name);
    }
    public static void one(Object obj) {
        System.out.println("01o" + obj);
    }

    @Override
    public void two(String name) {
        System.out.println("01s" + name);
    }

    @Override
    public void two(Object obj) {
        System.out.println("01o" + obj);
    }
}
