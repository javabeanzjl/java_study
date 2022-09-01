package com.wuying.exception_log_duanyan.exception;

import org.junit.jupiter.api.Test;

public class Test01 {

    public static void main(String[] args) {
        System.out.println(test01(2));
    }

    /**
     * finally中的return覆盖掉了try中的return；
     * @param i
     * @return
     */
    public static int test01(int i) {
        try {
            i++;
            return i;// return但不返回此时i = 3;
        } catch (Exception e) {
            
        } finally {
            i++;
            return i;// return并返回此时i = 4;
        }
    }
}
