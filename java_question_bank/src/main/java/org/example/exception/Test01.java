package org.example.exception;

import org.junit.jupiter.api.Test;

public class Test01 {
    public static void main(String[] args) {
        // 执行顺序
        // 先num=5，之后进行除0操作，发生异常并进行捕捉，进行num=10,之后执行finally语句块的内容。
        // System.out.println(val());

        // System.out.println(test01());// 3
        System.out.println(test02());
        // 结论：如果finally内有return，那么一定是最后执行的return。前面的return会执行但不返回
    }

    public static int val() {
        int num = 5;
        try {
            num = num / 0;
        } catch (Exception e) {
            num = 10;
        } finally {
            num = 15;
        }
        return num;
    }
    
    // try,catch,finally都有return，记住一点，finally语句块内容永远会执行
    public static int test01() {
        int a = 0;// 1、先执行
        try {
            a = a / 0;// 2、其次执行
            System.out.println("try中return没有执行");
            return a;// 发生异常不执行了。
        } catch (Exception e) {
            a = 2;// 3、执行此处
            System.out.println("此时catch中语句执行a=" + a);
            return a++;// 4、执行a++,但不返回
        } finally {
            System.out.println("finally语句块中的a=" + a);// 5、执行
            return a;// 6、执行
        }
    }

    // catch中有return，finally没中有return
    public static String test02() {
        int a = 0;// 1、先执行
        try {
            a = a / 0;// 2、其次执行
            System.out.println("try中return没有执行");
            return "try块中的return执行，a=" + a;// 发生异常不执行了。
        } catch (Exception e) {
            a = 2;// 3、执行此处
            System.out.println("此时catch中语句执行a=" + a);// 执行
            return "catch块中return执行，a=" + a++;// 4、执行a++,但不返回，6、返回结果
        } finally {
            System.out.println("finally语句块中的a=" + a++);// 5、执行
        }
    }

    // catch中没有return，finally中有return
    public static String test03() {
        int a = 0;// 1、先执行
        try {
            a = a / 0;// 2、其次执行
            System.out.println("try中return没有执行");
            return "try块中的return执行，a=" + a;// 发生异常不执行了。
        } catch (Exception e) {
            a = 2;// 3、执行此处
            System.out.println("此时catch中语句执行a=" + a);// 4、正常执行
        } finally {
            a++;
            System.out.println("finally语句块中的a=" + a);// 5、执行
            return "finally语句块中的return执行，a=" + a;// 6、执行
        }
    }
    
    // 未发生异常
    public static String test04() {
        int a = 1;
        try {
            System.out.println("try块执行a=" + a);// 1、先执行
            return "try块中的return执行，a=" + a++; // 执行了又没执行！！a确实进行自增了，但并没有返回
        } catch (Exception e) {
            System.out.println("catch块执行a=" + a);
            return "catch块中的return执行, a =" + a++;
        } finally {
            System.out.println("finally块执行a=" + a);// 2、直接执行了,此时a=2
            return "finally块中的return执行, a =" + a;// 3、直接执行了，此时a=2
        }
    }
    
    // 先创建了变量a并赋值为1
    // return中的返回执行时，是先创建了一个变量b，并把a赋值给b，之后执行a++，但返回b
    /*
    反编译结果：
    int a = 1;
    int b = a;
    a++;
    return b;*/
    public static String test05() {
        int a = 1;
        try {
            System.out.println("try块执行a=" + a);// 1、先执行
            return "try块中的return执行，a=" + a++; // 执行了又没执行！！a确实进行自增了，但并没有返回
        } catch (Exception e) {
            System.out.println("catch块执行a=" + a);
            return "catch块中的return执行, a =" + a++;
        } finally {
            System.out.println("finally块执行a=" + a);// 2、直接执行了,此时a=2
        }
    }
}
