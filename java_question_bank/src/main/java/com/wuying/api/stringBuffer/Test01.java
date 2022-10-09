package com.wuying.api.stringBuffer;

import org.junit.jupiter.api.Test;

public class Test01 {
    @Test
    public void test01() {
        StringBuffer str = new StringBuffer(10);
        str.append("ABC");
        System.out.println(str.length());// 字符串长度
        System.out.println(str.capacity());// 容量
    }
}
