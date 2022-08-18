package org.example.basis;

import org.junit.jupiter.api.Test;

public class Test01 {
    // ++i和i++
    @Test
    public void test01() {
        int i = 0;
        int a = i++;
        int b = ++a;
        System.out.println(a);
        System.out.println(b);
    }
    
    @Test
    public void test02() {
        Byte a = 127;
        Byte b = ++a;
        System.out.println(b);
    }
    // add方法对a、b来说一点用都没有呀，没返回呀。
    public void add(Byte b) {
        // b = b++;
        b++;
    }
    @Test
    public void test03() {
        Byte a = 127;
        Byte b = 127;
        add(a++);
        System.out.println("a=" + a);
        add(b);
        System.out.println("b=" + b);
    }
    
    @Test
    public void test04() {
        int[] arr = {1,4,2,5,3};
        swap(arr,0,4);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
    
    public static void swap(int[] arr,int start,int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


}
