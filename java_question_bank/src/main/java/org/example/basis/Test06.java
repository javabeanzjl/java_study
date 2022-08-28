package org.example.basis;

import org.junit.jupiter.api.Test;

public class Test06 {
    
    @Test
    public void test01() {
        Bfather bfather = new Ason();
        bfather.testInstance();
        Ason.testStatic();
    }
}
class Ason extends Bfather {
    @Override
    public void testInstance() {
        System.out.println("子类的实例方法");;
    }
    /*public static void testStatic() {
        System.out.println("子类的静态方法");
    }*/
}
class Bfather {
    public void testInstance() {
        System.out.println("父类的实例方法");
    }
    public static void testStatic() {
        System.out.println("父类静态方法");
    }
}
