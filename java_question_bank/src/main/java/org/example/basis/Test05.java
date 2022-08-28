package org.example.basis;

import org.junit.jupiter.api.Test;

public class Test05 {
    // 传参地址问题
    @Test
    public void test01() {
        start();
    }
    void start() {
        Two t = new Two();
        System.out.println(t.x);
        Two t2 = fix(t);
        System.out.println(t.x + " " + t2.x);
    }
    Two fix(Two tt) {
        tt.x = 42;
        return tt;// 这个tt传入时是个地址，所以t和t2其实指向的是同一个Two对象。x值当然也是同一个。
    }
}
class Two {
    Byte x;
}
