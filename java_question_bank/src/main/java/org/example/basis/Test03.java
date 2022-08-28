package org.example.basis;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(str);
            }
            System.out.println();
        }
    }
    
    @Test
    public void test01() {
        float f = 100.00f;
        double d = 100;
        Double d1 = Double.valueOf(1);
        int a = 1;
        float b = 2;
        System.out.println(a / b);
    }
    
    @Test
    public void test02() {
        
    }
}

