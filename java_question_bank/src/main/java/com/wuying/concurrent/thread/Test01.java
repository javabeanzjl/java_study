package com.wuying.concurrent.thread;

import org.junit.jupiter.api.Test;

public class Test01 extends Thread{
    // 没有重写run方法，这样只会调用父类的run方法，不会输出
    @Test
    public void test01() {
        Test01 test01 = new Test01();
        test01.run();
    }
    public  void start() {
        System.out.println("ss");
    }

    /**
     * yield()方法只是让当前线程进入就绪状态，重新抢夺时间片等待后续再次执行。并不是停止不运行了。
     */
    @Test
    public void test02() {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " run方法执行");
            yield();
            System.out.println(Thread.currentThread().getName() + " run方法再次抢夺到时间片");
        });
        Thread thread2 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " 线程开始"));
        thread1.start();
        thread2.start();
    }

    /**
     * Thread.sleep()方法必须捕捉异常。
     * java.lang.InterruptedException; 必须对其进行捕获或声明以便抛出
     */
    @Test
    public void test03() {
        Thread thread1 = new Thread(() -> {
            System.out.println("run方法执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
    }
}
