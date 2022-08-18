package org.example.basis;

public class B {
    {
        System.out.println("父类B的实例代码块执行");
    }
    static {
        System.out.println("父类B的静态代码块执行");
    }

    public B() {
        System.out.println("父类B的无参构造执行");
    }
    
    public void test1() {
        System.out.println("实例方法");
    }
    public static void test02() {
        System.out.println("静态方法");
    }
    public void test03() {
        test1();
    }
}
