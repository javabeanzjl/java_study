# java8

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