package com.wuying.extend.extend;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Test03 {
    /**
     * Employee继承了Person。所以初始化子类时，会先初始化父类，会调用父类的构造器。
     * 如果父类有无参构造， 则子类构造函数中可以不显示调用父类的构造函数。
     * 如果父类没有无参构造，则子类构造函数中必须显示调用父类的构造函数，否则编译错误。
     */
    @Test
    public void test01() {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}
class Person {
    String name = "No name";
    public Person() {}
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
        super();
        empID = id;
    }
    public Employee() {}
}
