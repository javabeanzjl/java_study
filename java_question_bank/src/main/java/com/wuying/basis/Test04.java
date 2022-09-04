package com.wuying.basis;

import org.junit.jupiter.api.Test;

public class Test04 {

    /**
     * ASCII码 a为97 b为98
     */
    @Test
    public void test01() {
        char x = 97;
        char y = 98;
        char z = (char) (x + y);
        System.out.println(x + "" + y);
        System.out.println("" + x + y);
        System.out.println(x + y + "");
        System.out.println(z);
    }

    /***
     * 127的二进制补码：01111111
     * 2的二进制补码：000000010
     * 127 + 2：
     *  01111111
     * +00000010
     * =10000001
     * 
     * 可以看到补码10000001为-127的补码，所以127 + 2 = -127
     */
    @Test
    public void test02() {
        char c = 127;
        byte b = 127;
        int sum = 200;
        c += 1;// java中没有溢出
        b += 1;// 溢出,补码变成-128
        // 0111 1111 --> 1000 0000
        System.out.println(sum + c);// 328
        System.out.println(sum + b);// 72
        byte v = (byte) (b + 1);
        System.out.println(v);
    }
    /**
     * 子类调用父类的构造器只需要在首行调用super()方法。传入对应构造器的参数即可。
     */
}
class Parent {
    private int data;
    public Parent(int d) {
        data = d;
    }
}
class Son extends Parent {
    String name;
    public Son(String s,int d) {
        super(d);
        name = s;
    }
}
