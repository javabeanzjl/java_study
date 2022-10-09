package com.wuying.interface_innerclass_lambada.innerclass;

import org.junit.jupiter.api.Test;

/**
 * Java内部类--成员内部类
 */
public class Test01 {
    private String name = "zhangsan";
    public static final int ID = 1001;
    public class Demo {
        public void method1() {
            System.out.println(name);
            System.out.println(ID);
            System.out.println(Test01.this.name);
        }
    }

    public static void main(String[] args) {
        // 方法一
        // 要创建内部类的对象前提是必须创建一个外部类的对象
        Test01 test01 = new Test01();
        // 必须通过外部类的对象test01来创建。
        Test01.Demo demo = test01.new Demo();
        demo.method1();
        // 方法二
    }
}

/**
 * Java内部类--局部内部类
 * 局部内部类只能访问局部final变量？？？
 */
class Test02 {
    private String name = "zhangsan";
    public static final int ID = 10;
    public static int age = 15;
    public int test01() {
        int a = 10;
        String pwd = "123";
        final String name = "lisi";
        // 局部内部类与局部变量一样，是不能有static，public、protected、private修饰符的
        class InnerClass {
            public void method1() {
                int a = 15;
                System.out.println(pwd);
                // 全局属性都能访问--就近原则，会选择内部的name属性。
                System.out.println(name + ID + age);
                // 要想访问外部类的同名属性，需要使用类名.this
                System.out.println(a + Test02.this.name);
                a++;
                System.out.println(a);
            }
        }
        class InnerClass2 {
            public void demo() {
                int b = a;
                // 由于a默认是final属性，所以不能进行修改。
                // a++;
                System.out.println(a);
            }
        }
        InnerClass innerClass = new InnerClass();
        innerClass.method1();
        // a = 4;
        return a;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.test01());
    }
}

/**
 * Java内部类--匿名内部类
 */
class Test03 {
    public void test() {
        // 这样就不会报错了，不过还要注意一点，在Java 8 之后，在内部类或 Lambda 表达式中访问的局部变量，
        // 如果不是 final 类型的话，编译器自动加上 final 修饰符，
        // 即 Java8 新特性：effectively final。所以在Java 8 之后我们不用声明 num 为 final 也是可以的。
        int num = 5;
        new Test02() {
            @Override
            public int test01() {
                // num++,匿名内部类中定义的
                System.out.println(num);
                return num;
            }
        }.test01();
        // num = 4;
    }
}

/**
 * Java内部类--静态内部类
 */
class Test04 {
    private String name = "zhangsa";
    public static final int ID = 10;
    private static String PWD = "ASD";
    public static class InnerClass {
        public static void main(String[] args) {
            // 显而易见，静态属性不管是否私有，都可以访问
            System.out.println(ID + PWD);
            // 非静态不能直接访问，即使通过类名.this的方式也不能访问。
            // System.out.println(Test04.this.name);
        }
    }
}

