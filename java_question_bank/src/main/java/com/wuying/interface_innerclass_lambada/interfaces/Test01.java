package com.wuying.interface_innerclass_lambada.interfaces;

import org.junit.jupiter.api.Test;

public interface Test01 {
    // 接口中不能只做变量声明
    // public String name;
    String name = "zhangsan";
}
class Test02 implements Test01{
    @Test
    public void test01() {
        // 接口中定义的变量均为常量。默认public static final
        // name = "lisi";
        System.out.println(name);
    }
}
