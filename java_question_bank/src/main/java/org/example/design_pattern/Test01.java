package org.example.design_pattern;

import org.junit.jupiter.api.Test;

public class Test01 {
    @Test
    public void test() {
        SingletonPattern singletonPattern1 = SingletonPattern.getInstance();
        SingletonPattern singletonPattern2 = SingletonPattern.getInstance();
        // 由于类变量只在类加载时初始化一次，所以
        System.out.println(singletonPattern1 == singletonPattern2);// true
        
    }
}
