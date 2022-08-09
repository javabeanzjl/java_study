package com.example.lanbada;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class Test02 {
    // 第一种情况，无参无返
    @Test
    public void test01() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("老鼠爱大米");
            }
        };
        runnable.run();
        System.out.println("------------------");
        
        /*Runnable runnable1 = () -> {
            System.out.println("老鼠爱大米");
        };// {}可省略*/
        Runnable runnable1 = () -> System.out.println("老鼠爱大米");
        runnable1.run();
    }
    
    // 第二种情况，一个参数，但没有返回值
    @Test
    public void test02() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("大米");
        System.out.println("--------------------");
        
        Consumer<String> con2 = (String s) -> System.out.println(s);
        con2.accept("大米");
    }
    
    // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test03() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("章鱼丸");
        System.out.println("-----------------------");
        
        Consumer<String> con2 = (s) -> System.out.println(s);
        
        con2.accept("章鱼丸");
    }
    
    // 语法格式4：若只需要一个参数，参数的小括号也可以省略
    @Test
    public void test04() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("牛肉");

        System.out.println("----------------------");
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("烤牛肉");
    }
    
    // 语法格式五：Lambada需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test05() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 30));
        System.out.println("--------------------------");
        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(31, 20));
    }
    
    // 语法格式6：当只有一条语句，return和大括号都可以省略
    @Test
    public void test06() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 30));
        System.out.println("------------------------------------");
        
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(12, 30));
    }
}
