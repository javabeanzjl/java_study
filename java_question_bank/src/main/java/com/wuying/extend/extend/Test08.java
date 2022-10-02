package com.wuying.extend.extend;

import org.junit.jupiter.api.Test;

public class Test08 {
    @Test
    public void test01() {
        Father zhangsan = new Son();
        zhangsan.sleep();
        // 编译看左边，运行看右边，所以无法调用子类独有的方法。
        // zhangsan.climb();
    }
    
}
class Father {
    public void run() {
        System.out.println("父类");
    }
    public void sleep() {
        System.out.println("父类");
    }
}
class Son extends Father {
    public Son() {
        // 由于子类重写了父类的sleep方法，所以需要使用super关键字。
        super.sleep();
    }
    public void sleep() {
        // 子类若没有重写父类的方法，则默认调用父类的方法。
        run();
    }
    public void climb() {
        System.out.println("子类独有");
    }
}
