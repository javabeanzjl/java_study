package com.wuying.extend.extend;

public class Test11 {
}
class A {
    public A(String s) {
        System.out.println("A");
    }
}
class B1 extends A {
    public B1(String s) {
        super(s);
        System.out.println("C");
    }
}
