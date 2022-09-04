package com.wuying.jvm;

import org.junit.jupiter.api.Test;

public class Test01 {
    /**
     * 类初始化时机：只有当对类的主动使用的时候才会导致类的初始化，类的主动使用包括以下六种：
     * – 创建类的实例，也就是new的方式
     * – 访问某个类或接口的静态变量，或者对该静态变量赋值
     * – 调用类的静态方法
     * – 反射（如Class.forName(“com.xxx.Test”)）
     * – 初始化某个类的子类，则其父类也会被初始化
     * – Java虚拟机启动时被标明为启动类的类（Java Test），直接使用java.exe命令来运行某个主类。
     */
    
    @Test
    public void test01() {
        System.out.println(Son.name);
        System.out.println("------------------------");
        System.out.println(Son.passowrd);
    }
    @Test
    public void test02() {
        Father father = new Son();
    }
}
class Father {
    static String name = "张三";
    static {
        System.out.println("父类静态代码块执行");
    }
}
class Son extends Father{
    static String passowrd = "123456";
    static {
        System.out.println("子类静态代码块执行");
    }
}
