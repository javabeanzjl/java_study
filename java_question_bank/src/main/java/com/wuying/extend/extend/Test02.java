package com.wuying.extend.extend;

public class Test02 {
    public static void one(String name) {
        System.out.println("02" + name);
    }
    public static void one(Object obj) {
        System.out.println("02" + obj);
    }
    public void two(String name) {
        System.out.println("02s" + name);
    }
    public void two(Object obj) {
        System.out.println("02o" + obj);
    }
}
