# java8

java8中有两大最为重要的改变。一个是Lambada表达式，另外一个则是Stream API

## 1、lambada表达式

java8新特性。使代码更简洁

- 举例：(01,02) -> Integer.compare(o1,o2);

- 格式：

​	-> ：Lambada操作符 或 箭头操作符

​	-> 左边：Lambada形参列表（其实就是接口中的抽象方法的形参列表）

​	-> 右边：Lambada体（其实就是重写的抽象方法的方法体）

- lambada表达式的使用：（分为6种情况）

- Lambada表达式的本质：作为接口的实例

  ```java
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
  ```

- 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口

- Java内置四大核心函数式接口
  - 函数式接口									参数类型			返回类型			用途
  - Consumer<T> 消费型接口                T                       void              void accept(T t);
  - Supplier<T> 供给型接口                   无                        T                  T get();
  - Function<T,R> 函数型接口                T                         R                  R apply(T t);
  - Predicate<T> 断定型接口                  T                    boolean          boolean test(T t);
  
  ```java
  @Test
  public void test01() {
      // Consumer消费型接口
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
  ```

## 2、方法引用

- 使用情景：当 要传递给lambada体的操作已经有实现的方法了，可以使用方法引用

- 方法引用：本质上就是Lambada表达式，而Lambada表达式作为函数式接口的实例，所以方法引用也是

- 使用格式：类（对象）::  方法名

- 具体分为如下三种情况

  - 对象 ::非静态方法
  - 类  :: 静态方法
  - 类  ::非静态方法

  ```java
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
  ```

## 3、构造器引用和数组引用

### 3.1、构造器引用

与方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致，抽象方法的返回值即是构造器所属的类的类型

```java
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
```

### 3.2、数组引用

可以把数组看做成一个特殊的类，这样数组引用就与构造器引用写法类似了

```java
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
```

## 4、Stream API

### 41.、Stream

是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列

- Stream自己不会存储元素
- Stream不会改变源对象，相反，他们会返回一个持有结果的新Stream
- Stream操作是延迟执行的，这意味着他们会等到需要结果时候才执行

Stream的操作有三个步骤

1. 创建Stream

2. 中间操作

3. 终止操作（终端操作）

   一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用

#### 4.1.1、创建Stream

--一个数据源（如：集合、数组），获取一个流

```java
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
```

#### 4.1.2、中间操作

--一个中间操作链，对数据源的数据进行处理

多个中间操作可以连接形成流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理

- 筛选与切片

  ```java
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
  ```

- 映射

  ```java
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
  ```

- 排序

  ```java
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
  ```

#### 4.1.3、终止操作

终端操作会从流的流水线生成结果，其结果可以是任何不是流的数据。如List，Integer等，流进行终止操作之后将不能再次使用。

- 匹配与查找

  ```java
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
  ```

- 归约

  ```java
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
  ```

- 收集

  ```java
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
  ```

## 5、Optional类

可以避免空指针异常

### 5.1、创建Optional类对象的方法

```java
// 创建Optional类对象的三种方法
@Test
public void test01() {
    // static <T> Optional<T>	of(T value)
    // 返回具有 Optional的当前非空值的Optional。
    Girl girl = new Girl();
    // girl = null;
    Optional<Girl> optionalGirl = Optional.of(girl);// of方法参数必须非空
    System.out.println(optionalGirl);
    System.out.println("-----------------------------------");
    // static <T> Optional<T>	ofNullable(T value)
    // 返回一个 Optional指定值的Optional，如果非空，则返回一个空的 Optional 。
    girl = null;
    Optional<Girl> girlOptional = Optional.ofNullable(girl);// ofNullable参数可以为空，返回Optional.empty
    System.out.println(girlOptional);
    System.out.println("-----------------------------------");
    // static <T> Optional<T>	empty()
    // 返回一个空的 Optional实例。   
    Optional<Object> empty = Optional.empty();
    System.out.println(empty);
}
```

### 5.2、判断Optional容器是否包含对象

### 5.3、获取Optional容器的对象

- get()方法：如果有值则返回，否则抛异常
- orElse(T other)：如果有值则将其返回，否则返回other
- orElseGet(Supplier<? extends T> other)：如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
- orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返回，否则抛出Supplier接口实现提供的异常。

```java
// 获取男孩的女孩姓名
public String getGirlName(Boy boy) {
    // 原先这样做---java.lang.NullPointerException
    // return boy.getGirl().getName();
    // 为了避免空指针异常，现在这样做
    /*还是繁琐
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;*/
    // 有了Optional之后
    // T	orElse(T other)
    //  返回值如果存在则返回，否则返回 other 。
    Optional<Boy> boyOptional = Optional.ofNullable(boy);
    // 此时的boy一点非空
    Boy boy1 = boyOptional.orElse(new Boy(new Girl("古力娜扎")));
    Optional<Girl> girlOptional = Optional.ofNullable(boy1.getGirl());
	
    Girl girl = girlOptional.orElse(new Girl("迪丽热巴"));

    return girl.getName();
}
@Test
public void test02() {
    Boy boy = new Boy();
    // boy = null;
    String girlName = getGirlName(boy);
    System.out.println(girlName);
}
```

