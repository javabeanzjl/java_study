package org.example.basis;

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
}
