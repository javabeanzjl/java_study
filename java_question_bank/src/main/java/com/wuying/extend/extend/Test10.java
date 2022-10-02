package com.wuying.extend.extend;

import org.junit.jupiter.api.Test;

public class Test10 {
    @Test
    public void test01() {
        B b = new B();
    }
}

/**
 * 并不是静态代码块优先执行，而是静态域优先执行
 * 静态域中包含静态变量，静态代码块，静态方法
 * 是按照顺序进行加载的。
 * 
 * 静态代码块在静态变量上边。
 * 静态代码块执行
 * 实例代码块执行
 * 构造器执行
 * 实例代码块执行
 * 构造器执行
 * 实例代码块执行
 * 构造器执行
 * 
 * 静态变量在静态代码块上边，由于静态域只加载一次，所以静态代码块在第三次才加载。
 * 实例代码块执行
 * 构造器执行
 * 实例代码块执行
 * 构造器执行
 * 静态代码块执行
 * 实例代码块执行
 * 构造器执行
 */
class B {
    public static B t1 = new B();
    public static B t2 = new B();
    
    {
        System.out.println("实例代码块执行");
    }
    static {
        System.out.println("静态代码块执行");
    }

    public B() {
        System.out.println("构造器执行");
    }
    public static void main(String[] args) {
        B b = new B();
    }
}

