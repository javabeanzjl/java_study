package com.example.stream_api;

import com.example.method_reference.Employ;
import com.example.method_reference.EmployData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream的中间操作
 */
public class Test02 {
    // 筛选与切片
    @Test
    public void test01() {
        List<Employ> employees = EmployData.getEmployees();
        // filter(Predicate p)--接收Lambda，从中排除某些元素
        // 获取年龄大圩23的员工信息
        employees.stream().filter(e -> e.getAge() > 23).forEach(System.out::println);

        System.out.println("----------------------------------");
        // limit(n)--截断流，使其元素不超过给定数量
        // 获取工资大于1000的3人--顺序流和并行流
        employees.stream().filter(e -> e.getSalary() > 1000).limit(3).forEach(System.out::println);
        System.out.println("---------------------------------");
        employees.parallelStream().filter(e -> e.getSalary() > 1000).limit(3).forEach(System.out::println);

        System.out.println("----------------------------------------");
        // skip(n) --跳过元素，返回一个扔掉前n个元素之后的流，若流中元素个数不足n个,则为空
        employees.stream().skip(10).forEach(System.out::println);
        System.out.println("--------------------------------------");
        employees.parallelStream().skip(2).forEach(System.out::println);

        System.out.println("---------------------------------------");
        // distinct()--筛选，通过流所生成元素的hashCode()和equals（）去除重复元素
        employees.add(new Employ(1001,23,"zhangsan",12312));
        employees.add(new Employ(1001,23,"zhangsan",12312));
        employees.add(new Employ(1001,23,"zhangsan",12312));
        System.out.println(employees);
        System.out.println("----------------------------------------------");
        employees.stream().distinct().forEach(System.out::println);
    }
    
    // 映射
    @Test
    public void test02() {
        // map(Function<? super T,? extends R> mapper)--返回由给定函数应用于此流的元素的结果组成的流。
        List<String> stringList = Arrays.asList("Aa", "Bb", "Cc", "Dd");
        stringList.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        System.out.println("-------------------------------------------------------");
        // 获取员工姓名长度大于3的员工的姓名
        List<Employ> employs = EmployData.getEmployees();
        /*Stream<String> stringStream = employs.stream().map(Employ::getName);
        stringStream.filter(name -> name.length() > 3).forEach(System.out::println);*/
        employs.stream()
                .map(Employ::getName)
                .filter(name -> name.length() > 3)
                .forEach(System.out::println);

        System.out.println("------------------------------");
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        Stream<Stream<Character>> streamStream = list.stream().map(Test02::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println("--------------------------------");
        // flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
        // 返回由通过将提供的映射函数应用于   每个元素而产生的映射流的内容   来替换该流的每个元素的结果的流。
        Stream<Character> characterStream = list.stream().flatMap(Test02::fromStringToStream);
        characterStream.forEach(System.out::println);
        System.out.println("--------------------------------");
    }
    
    // 将字符串中的每个字符构成的集合转换为对应的Stream实例
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<> ();
        for (Character c: str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
    // 排序
    @Test
    public void test04() {
        // sorted() --自然排序
        List<Integer> list = Arrays.asList(1,2,33,44,2,33,12,3,5);
        list.stream().sorted().forEach(System.out::println);
        
        // sorted(Comparator com) --定制排序
        // 先按年龄排，年龄相同按薪资排
        List<Employ> employList = EmployData.getEmployees();
        employList.stream().distinct().sorted((e1,e2) -> {
            int ageValue = Integer.compare(e2.getAge(),e1.getAge());
            if (ageValue != 0) {
                return ageValue;
            } else {
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }
}
