package org.example.basis;

import org.junit.jupiter.api.Test;

public class A extends B{
    static {
        System.out.println("子类A的静态代码块执行");
    }

    public A() {
        System.out.println("子类A的无参构造执行");
    }

    {
        System.out.println("子类A的实例代码块执行");
        
    }
    // 代码块和构造方法的执行顺序
    // 若有静态代码块先执行父类的再执行子类的，之后先后执行父类的实例代码块和无参构造，再执行子类的实例代码块和无参构造
    public static void main(String[] args) {
        A a = new A();
        
    }
    @Test
    public void test() {
        test1();
        test02();   
    }   
}
