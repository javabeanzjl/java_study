package com.example.lanbada;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// 函数式接口
public class Test03 {
    // Consumer消费型接口
    @Test
    public void test01() {
        
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("消费了缪鼐");
        System.out.println("--------------------------");
        
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("老鼠挨打米");
    }
    // 供给型接口Supplier
    @Test
    public void test02() {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "老鼠";
            }
        };
        System.out.println(supplier.get());
        System.out.println("----------------------------");
        Supplier<String> supplier1 = () -> "老鼠";
        System.out.println(supplier1.get());
        System.out.println("--------------------------------");
    }
    // Function<T,R> 函数型接口
    @Test
    public void test03() {
        Function<String,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 200;
            }
        };
        System.out.println(function.apply("大米"));
        System.out.println("--------------------------------------");
        Function<String, Integer> function1 = (s -> 1);
        System.out.println(function1.apply("鸡蛋"));
        System.out.println("-----------------------------------------");
    }
    // Predicate<T> 断定型接口
    @Test
    public void test04() {
        List<String> list = Arrays.asList("背景","背tianjing","上海","兰州","马来西苑");
        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() < 3;
            }
        });
        System.out.println(filterString);
        System.out.println("------------------------------------");
        List<String> filter = filterString(list,s ->  s.contains("背"));
        System.out.println(filter);
        System.out.println("--------------------------");
        List<String> filterList = filterString(list, s -> s.length() < 3);

        System.out.println(filterList);
    }
    
    // 根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
    public ArrayList<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> arrayList = new ArrayList<>();
        
        for (String s: list) {
            if (pre.test(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }
}
