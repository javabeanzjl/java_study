package com.wuying.concurrent.thread;

import com.sun.xml.internal.bind.v2.runtime.NameList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于synchronized关键字
 */
public class Test03 {
    
    private List names = new ArrayList();
    
    public synchronized void add(String name) {
        names.add(name);
    }
    public synchronized void printAll() {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + "");
        }
    }

    /**
     * 打印完毕一定有C打印完。所以答案可能是AB__任意非C___C___任意非C____C
     * @param args
     */
    public static void main(String[] args) {
        final Test03 sl = new Test03();
        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    sl.add("A");
                    sl.add("B");
                    sl.add("C");
                    sl.printAll();
                }
            }.start();
        }
    }

    /**
     * ==判断两个字符串是否相等。
     */
    @Test
    public void test01() {  
        String a = "str";
        String b = "str";
        String c = a + b;// 新建了一个String
        String d = c;
        String f = "strstr";
        String g = "str" + "str";
        String h = "str" + a;
        System.out.println((a + b) == c);// false
        System.out.println(d == f);// false
        System.out.println(c == f);// false
        System.out.println(c == g);// false
        System.out.println(f == g);// true
        System.out.println(h == g);// false
    }

    {
        System.out.println("实例代码块1执行");
    }
    {
        System.out.println("实例代码块2执行");
    }
    static {
        System.out.println("静态代码块1执行");
    }
    static {
        System.out.println("静态代码块2执行");
    }
    @Test
    public void test02() {
        /**
         * 实例代码块和静态代码块都可以写多次。
         */
    }
}
