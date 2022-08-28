package org.example.thread;

public class Test01 {
    public static void main(String args[]) {
        
        for (int i = 0; i < 100; i++) {
            Thread t=new Thread(){
                public void  run(){
                    dianping();

                }
            };
            t.start();
            System.out.print("dazhong");
            System.out.println();
        }
    }
    static void dianping(){
        System.out.print("dianping");
    }
}
