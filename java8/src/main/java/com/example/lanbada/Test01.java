package com.example.lanbada;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class Test01 {
    @Test
    public void test01() {
        
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("老鼠爱大米");
            }
        };
        r1.run();

        System.out.println("--------------------");
        
        Runnable r2 = () -> {
            System.out.println("猫抓老鼠");
        };
        r2.run();
    }
    
    @Test
    public void test02() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare = com1.compare(12, 31);
        System.out.println(compare == -1 ? "o1<o2" : ">");
        System.out.println("------------------------");
        
        /*Comparator<Integer> com2 = (o1, o2) -> {
            return Integer.compare(o1,o2);
        };*/
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(31, 12));
        
        // 方法引用
        Comparator<Integer> com3 = Integer ::compare;

        int compare1 = com3.compare(32, 12);

        System.out.println(compare1);
    }
    
}
