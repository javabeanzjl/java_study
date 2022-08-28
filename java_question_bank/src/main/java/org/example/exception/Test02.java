package org.example.exception;

import org.junit.jupiter.api.Test;

public class Test02 {
    // 测试如果循环中抛出异常但不捕捉，循环是否终止
    // 测试结果，finally之后会抛出异常，try执行第三次时
    @Test
    public void test01() {
        for (int i = 0; i < 10; i++) {
            try {
                if (i == 2) {
                    throw new NullPointerException();
                }
                System.out.println("try执行第" + i + "次");
            } finally {
                System.out.println("执行finally");
            }
        }
    }
    
}
