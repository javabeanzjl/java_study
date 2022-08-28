package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        String str = new String(new char[5]).replace('\0','0');
        System.out.println(str);
    }
}
