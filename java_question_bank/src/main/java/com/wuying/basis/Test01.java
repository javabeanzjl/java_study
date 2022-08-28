package com.wuying.basis;

import org.junit.jupiter.api.Test;

public class Test01 {
    /**
     * 关于运算符
      */
    @Test
    public void test01() {
         Object obj = (short) 10 / 10.2;
         Object obj1 = (short)(10 / 10.2);
        System.out.println(obj.getClass().getName());
        System.out.println(obj1.getClass().getName());
        // 结论。一元运算符优先于4则运算符
    }
    /**
     * 关于ASCII码值
     * 空格为32，数字0为48，"A"为65，"a"为97；
     */
    
    // 显然abstrat和final是不可以同时使用的。
    // public abstract final String NAME = "ZH";

    /**
     * 垃圾回收什么时候才能开始呢？
     */

    public static void main(String args[]) {
        start();
    }
    
    public static class A {
        private B ref;
        public void setB(B b) {
            ref = b;
        } 
    }
    
    public static class B {
        private A ref;
        public void setA(A a) {
            ref = a;
        }
    }
    
    public static void start() {
        A a = new A();// 堆内存中开辟，内存地址0x001
        B b = new B();// 堆内存中开辟，内存地址0x002
        a.setB(b);// 会把0x002地址赋给ref这个引用，
        b = null;// 会将B b的内存地址清空，但0x002内存还在，并且A中的ref指向这个引用
        a = null;// 会将A a的内存地址清空，此时0x001和0x002这两个地址的内存空间并没有任何引用指向他们。
        // 垃圾回收可以开始进行。
    }
}
