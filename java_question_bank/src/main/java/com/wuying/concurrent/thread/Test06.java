package com.wuying.concurrent.thread;

/**
 * 抛出InterruptedException异常会导致线程中断吗？
 * 显然抛出异常仍然能够进行，因为这是一个
 */
public class Test06 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始执行");
        });
        thread.start();
        try {
            throw new InterruptedException();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程仍然在执行");
    }
}
