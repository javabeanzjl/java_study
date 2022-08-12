package com.example.stream_api;

import com.example.method_reference.Employ;
import com.example.method_reference.EmployData;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// 终止操作
public class Test03 {
    // 匹配与查找
    @Test
    public void test01() {
        List<Employ> employList = EmployData.getEmployees();
        // 	allMatch(Predicate<? super T> predicate)
        //  返回此流的所有元素是否与提供的谓词匹配。--一个不满足就返回false
        // 是否所有的员工都姓张
        System.out.println(employList.stream().allMatch(employ -> employ.getName().contains("张")));
        
        // anyMatch(Predicate<? super T> predicate)
        //  返回此流的任何元素是否与提供的谓词匹配。--一个满足就返回true
        // 有员工姓张吗
        System.out.println(employList.stream().anyMatch(e -> e.getName().contains("张")));
        
        //	noneMatch(Predicate<? super T> predicate)
        //  返回此流的元素是否与提供的谓词匹配。
        // 是否有员工不姓张--true全姓张
        System.out.println(employList.stream().noneMatch(e -> e.getName().contains("张")));
        
        // findFirst()
        // 返回描述此流的第一个元素的Optional如果流为空，则返回一个空的Optional.
        Optional<Employ> optionalEmploy = employList.stream()
                .distinct()
                .filter(e -> e.getSalary() > 4000)
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))// 按工资排序降序
                .findFirst();
        // findAny()
        // 返回描述流的一些元素的Optional如果流为空，则返回一个空的Optional 。
        // 返回工资大于4000的任意一个员工
        System.out.println(employList.parallelStream()
                .distinct()
                .filter(e -> e.getSalary() > 1000)
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))// 按工资排序降序
                .findAny());// ???咋全一样，是并行流呀
        System.out.println("-------------------------------------");
        // 测试以下并行流
        List<Integer> list = new ArrayList<>(1000);
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        Set<Optional<Integer>> optionalSet = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            optionalSet.add(list.parallelStream().findAny());
        }
        // 重复的不要好吧
        optionalSet.stream().forEach(System.out::println);
        // 不是很理解为什么并行流遍历每次都生成相同的。打印太快了？并行流太快了
        System.out.println("-----------------------");
        System.out.println(list.stream().max(Integer::compare));
        System.out.println(employList.stream().map(e -> e.getSalary()).max(Double::compare));
        System.out.println("---------------------------------");
        System.out.println(employList.stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).findFirst());
        System.out.println("----------------------------");
        // 麻烦不
        // 返回工资最低的员工
        System.out.println(employList.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).findFirst());
        Optional<Employ> employOptional = employList.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employOptional);
        // forEach(Consumer c)--内部迭代
        employList.stream().forEach(System.out::println);

    }

    // 归约
    @Test
    public void test03() {
        // reduce(T identity, BinaryOperator<T> accumulator)
        // 使用提供的身份值和 associative累积功能对此流的元素执行 reduction ，并返回减小的值。
        // 简单来说就是将流中的元素反复结合起来，得到一个值，返回Optional<T>
        // 计算员工年龄总和,员工数量以及平均工资，并找出未达到平均工资的员工姓名
        List<Employ> employList = EmployData.getEmployees();
        int num = (int) employList.stream().distinct().count();
        System.out.println(num);
        Optional<Double> salarySum = employList.stream().map(Employ::getSalary).reduce((d1, d2) -> d1 + d2);
        System.out.println(salarySum);
        double salary = Double.parseDouble(String.format("%.2f", salarySum.get() / num));
        System.out.println(salary);
        employList.stream().filter(e -> e.getSalary() > salary).map(e -> e.getName()).forEach(System.out::println);
    }
    
    // 收集
    // collect(Collect c) 将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中做汇总的方法
    @Test
    public void test04() {
        // collect(Collector<? super T,A,R> collector)
        // 使用 Collector对此流的元素执行 mutable reductionCollector 。
        // 查找工资大于6000的员工，返回List或者Set
        List<Employ> employees = EmployData.getEmployees();
        List<Employ> employList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employList.forEach(System.out::println);
        System.out.println("-------------------------------");
        employList.stream().forEach(System.out::println);
        System.out.println("--------------------------------------");
        Set<Employ> employSet = employees.stream().filter(e -> e.getAge() > 13).collect(Collectors.toSet());
        employSet.stream().forEach(System.out::println);
        System.out.println("------------------------------");
    }
    
    // 用线程模拟以下--多跟线程模拟还好说
    @Test
    public void test02() {
        List<Integer> list = new ArrayList<>(1000);
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        Set<Optional<Integer>> optionalSet = new HashSet<>();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    optionalSet.add(list.parallelStream().findAny());
                    Thread.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            optionalSet.stream().forEach(System.out::println);
        });
        thread.run();
    }
    
    
}
