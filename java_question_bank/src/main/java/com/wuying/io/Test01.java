package com.wuying.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        try {
            int read = System.in.read();
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test01() {  
        Scanner s = new Scanner(System.in);
        String  str = s.next();
        System.out.println(str);
        
    }
}
