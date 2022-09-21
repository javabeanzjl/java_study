package com.wuying.extend.extend;

import org.junit.jupiter.api.Test;

public class Test07 {
    @Test
    public void test01() {
        Animal cat = new Cat();
        cat.run("跑"); 
    }
    abstract static class Animal {
        public static void run(String s) {
            System.out.println("父类" + s);
        }
    }
    static class Cat extends Animal {
        public static void run(String s) {
            System.out.println("子类" + s);
        }
    }
}
