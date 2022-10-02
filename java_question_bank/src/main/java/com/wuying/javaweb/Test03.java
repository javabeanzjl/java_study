package com.wuying.javaweb;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test03 {
    @Test
    public void test01() {
        try {
            // 格式对就不抛出异常。
            URL url = new URL("http://www.1234234.com");
            System.out.println(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
