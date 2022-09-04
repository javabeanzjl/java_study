package com.wuying.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test02 {
    /**
     * 使用Callable接口完成创建线程
     */
    public void test01() {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return 1;
            }
        }); 
    }

    public static void main(String[] args) {
        
    }
    public void go() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        Thread t = new Thread();
        t.start();
    }
    
    
}
