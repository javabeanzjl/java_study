package com.example.method_reference;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用和函数引用
 */
public class Test02 {
    
    // 构造器引用
    // Supplier中的 T get()
    // Employ 中的 空构造器 Employ()
    @Test
    public void test01() {
        Supplier<Employ> sup1 = new Supplier<Employ>() {
            @Override
            public Employ get() {
                return new Employ();
            }
        };
        System.out.println(sup1);
        System.out.println("-----------------------------");
        Supplier<Employ> sup2 = () -> new Employ();
        System.out.println(sup2);

        System.out.println("-0-----------------------------");
        Supplier<Employ> sup3 = Employ::new;
        System.out.println(sup3);
    }
    
    // Function中的 R apply(T t)
    // Employ 中的 Employ(int id)
    @Test
    public void test02() {
        Function<Integer,Employ> fun1 = id -> new Employ(id);
        System.out.println(fun1.apply(123));

        System.out.println("-------------------------------");
        Function<Integer,Employ> fun2 = Employ::new;
        System.out.println(fun2.apply(163));

    }
    
    // 数组引用
    // Function 中的 R apply(T t)
    @Test
    public void test03() {
        Function<Integer,String[]> fun1 = length -> new String[length];
        System.out.println(fun1.apply(12));

        System.out.println("----------------------------------------");
        Function<Integer,String[]> fun2 = String[]::new;
        System.out.println(fun2.apply(12));
    }
}
