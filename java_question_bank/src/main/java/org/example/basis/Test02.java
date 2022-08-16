package org.example.basis;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // System.out.print("请输入整数：");
        // 空格即是两次键盘输入的分隔符
        int i = s.nextInt();
        int j = s.nextInt();
        
        System.out.println(j);
    }
    // 保留两位小数方法，使用String.format，和使用java.text.DecimalFormat类的DecimalFormat()方法。
    @Test
    public void test01() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(0.003254));
        System.out.println(String.format("%.2f",2314.12412));
    }
}
