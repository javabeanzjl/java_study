package com.wuying.concurrent.thread;

/**
 * Daemon线程--守护线程
 * User线程----用户线程
 * 用户线程全部结束后，守护线程即使没有执行完毕也会停止。
 */
public class Test05 {
}
class DaemonDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("aaa");
           while (true) {
               System.out.println("orz");
           }
        });
        // 如果没有把setDaemon设置为true，那么程序将会不断输出orz
        // setDaemon一定是在start之前。
        // 守护线程，主线程执行完毕，不管守护线程是否执行完毕都停止。
        thread.setDaemon(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
    }
    
    public synchronized static void mainThread() {
        try {
            /**
             * 如果在非同步控制方法里调用java.util.concurrent.locks.Condition
             * 中的await()和signalAll()或者Object中的wait()，notify()和notifyAll()方法，
             * 程序能通过编译，但运行的时候，将得IllegalMonitorStateException异常。
             */
            Thread.currentThread().wait(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
