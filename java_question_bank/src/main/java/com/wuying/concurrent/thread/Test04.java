package com.wuying.concurrent.thread;

import org.junit.jupiter.api.Test;

public class Test04 {
    /**
     * join()方法
     */
    @Test
    public void test01() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
            }
        });
        try {
            thread.start();
            thread.join();// 当前线程执行完毕才可以继续执行下方代码
            System.out.println("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
