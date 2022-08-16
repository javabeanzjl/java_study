package org.example.innerclass;

import org.junit.jupiter.api.Test;

public class Test01 {
    // 可以运行成功吗？可以运行成功
    public static void main(String[] args) {
        Object obj = new Object(){
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };
        String str = "abc";
        /*
        Object obj1 = str;
        System.out.println(obj1.getClass());
        System.out.println(obj.getClass());
        System.out.println(obj1 instanceof String);*/
        System.out.println(str.equals(obj));
        Demo demo = new Demo(); 
        demo.test1();
    }
    public static class Demo {
        public void test1() {
            System.out.println("内部类可以有public class");
        }
    }
}
