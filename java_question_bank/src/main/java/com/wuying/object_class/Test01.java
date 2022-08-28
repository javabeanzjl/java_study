package com.wuying.object_class;

import org.junit.jupiter.api.Test;

public class Test01 {
    
    public static String name = "张三";
    // static关键字修饰成员变量为类变量，每个类的实例对象将共享一个name
    // 所以只要修改一个，其他的都跟着变
    @Test
    public void test01() {
        Test01 test01 = new Test01();
        test01.name = "李四";
        Test01 test011 = new Test01();
        System.out.println(test01.name);// 李四
        System.out.println(test011.name);// 李四
    }
}
