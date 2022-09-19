package com.wuying.javaweb.tomcat.test01;

/**
 * 一个简单web容器的设计和实现：对静态资源
 */
public class Test {
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }
}
