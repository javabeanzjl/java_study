package org.example.basis;

import org.junit.jupiter.api.Test;

public class Test04 {
    
    // String重写equals方法了吗？
    @Test
    public void test01() {
        String a = "A";
        String b = new String("A");
        System.out.println(a.equals(b));// true,重写了equals方法，不信点进去看看
    }
}
