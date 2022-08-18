package com.example.stream_api;

import com.example.method_reference.Employ;
import com.example.method_reference.EmployData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * StreamAPI方法实测
 */
public class Test01 {
    
    // 创建stream方式一：通过集合
    @Test
    public void test01() {
        
        List<Employ> employees = EmployData.getEmployees();
        
        // default Stream<E> stream()：返回一个顺序流
        Stream<Employ> employStream = employees.stream();
        
        // default Stream<E> paralleStream()：返回一个并行流
        Stream<Employ> employStream1 = employees.parallelStream();
    }
    // 创建方式二：通过数组
    @Test
    public void test02() {
        int[] arr = new int[]{1,32,62,6};
        // 通过Arrays类的static <T> Stream<T> stream(T[] array):返回一个流
        IntStream intStream = Arrays.stream(arr);
        
        Employ employ1 = new Employ(1001,23,"zhangsan",1243124);
        Employ employ2 = new Employ(1002,24,"ligsan",33124);
        Employ[] e = new Employ[]{employ1,employ2};
        Stream<Employ> employStream = Arrays.stream(e);
    }
    // 创建方式三：通过Stream的of()
    @Test
    public void test03() {
        Stream<Integer> integerStream = Stream.of(1, 2, 34, 4, 4, 4);
    }
    
    // 创建方式四：创建无限流
    @Test
    public void test04() {
        // 迭代
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        // 遍历10个偶数
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);

        System.out.println("------------------------------------");
        // 生成
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(4).forEach(System.out::println);
    }
}
