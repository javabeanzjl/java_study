package com.example.method_reference;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 测试方法引用
 */
public class Test01 {
    
    // 方法引用
    // 1、对象：非静态方法(实例方法)
    // Consumer中的void accept(T t)方法
    // PrintStream中的 void println(T t)方法
    @Test
    public void test01() {
        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("面包");
        System.out.println("-----------------------------");
        Consumer<String> con2 = System.out::println;
        con2.accept("面包");
    }
    // Supplier中的T get()
    // Employ中的String getName()
    @Test
    public void test02() {
        Employ emp = new Employ(1001,23,"张三",10012);
        Supplier<String> supplier = () -> emp.getName();
        System.out.println(supplier.get());
        System.out.println("------------------------------------------");
        Supplier<String> supplier1 = emp::getName;
        System.out.println(supplier1.get());
    }
    
    // 2、类：:静态方法
    // Comparator中的 int compare(T t1,T t2)
    // Integer中的 int compare(T t1, T t2)
    @Test
    public void test03() {
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(12, 32));
        System.out.println("-------------------------------------");
        
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12, 32));
    }
    // Function中的R apply(T t)
    // Math中的Long round(Double d)
    @Test
    public void test04() {
        Function<Double,Long> fun1 = d -> Math.round(d);
        System.out.println(fun1.apply(12.2));
        System.out.println("----------------------------");
        
        Function<Double,Long> fun2 = Math::round;
        System.out.println(fun2.apply(23.2));
    }
    
    // 类：：非静态方法(实例方法)
    // Comparator<T>中的int compare(T t1,T t2)方法
    // String中的 int t1.compareTo(t2)方法
    @Test
    public void test05() {
        Comparator<String> com1 = (t1,t2) -> t1.compareTo(t2);
        System.out.println(com1.compare("hello", "hello1"));

        System.out.println("-------------------------------");
        
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("14", "13"));
    }
    // BiPredicate中的boolean test(T t1,T t2)
    // String 中的 boolean t1.equals(t2)
    @Test
    public void test06() {
        BiPredicate<String,String> bip1 = (s1,s2) -> s1.equals(s2);
        System.out.println(bip1.test("abc", "abc"));

        System.out.println("-------------------------------------");
        BiPredicate<String,String> bip2 = String::equals;
        System.out.println(bip2.test("abc", "vas"));
    }
    // Function中的 R apply(T t)
    // Employ中的 String getName()
    @Test
    public void test07() {
        Employ employ = new Employ(1001,23,"中国航",782914.123);
        Function<Employ,String> fun1 = e -> e.getName();
        System.out.println(fun1.apply(employ));

        System.out.println("------------------------------");
        Function<Employ,String> fun2 = Employ::getName;
        System.out.println(fun2.apply(employ));
    }
}
