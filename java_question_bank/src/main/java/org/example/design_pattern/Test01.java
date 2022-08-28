package org.example.design_pattern;

import org.junit.jupiter.api.Test;

public class Test01 {
    @Test
    public void test() {
        SingletonPattern_hungry singletonPattern1 = SingletonPattern_hungry.getInstance();
        SingletonPattern_hungry singletonPattern2 = SingletonPattern_hungry.getInstance();
        // 由于类变量只在类加载时初始化一次，所以
        System.out.println(singletonPattern1 == singletonPattern2);// true
        
        // 只在调用时候加载一次。
        Singletonpattern_lazy singletonpattern_lazy1 = Singletonpattern_lazy.getInstance();
        Singletonpattern_lazy singletonpattern_lazy2 = Singletonpattern_lazy.getInstance();
        System.out.println(singletonpattern_lazy1
         == singletonpattern_lazy2);
        singletonpattern_lazy1.test();
        
    }
}
