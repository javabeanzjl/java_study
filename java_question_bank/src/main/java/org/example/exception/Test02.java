package org.example.exception;

public class Test02 {
    public static String sRet = "";
    public static void func(int i) {
        try {
            if (i%2==0) {
                throw new Exception();
            }
        }
        catch (Exception e) {
            sRet += "0";
            return;
        }
        finally {
            sRet += "1";
        }
        sRet += "2";
        System.out.println("s");
    }
    public static void main(String[] args)
    {
        func(1);
        func(2);
        System.out.println(sRet);
    }
}
