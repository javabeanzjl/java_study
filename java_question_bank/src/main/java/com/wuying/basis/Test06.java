package com.wuying.basis;

import org.junit.jupiter.api.Test;

public class Test06 {
    @Test
    public void test01() {
        int n = 2;
        int z = 0;
        for (int i = 0; i <= n - 1; i++) {
            for (int j = n; j > i; j--) {
                z++;
            }
        }
        /**
         * i = 0时，n
         * i = 1时，n - 1
         * i = n - 1时，1
         * 所以还是(n + 1) / 2;
         */
        // 0+1+2+3+...+n = (1 + n) / 2;
        System.out.println(z);
    }
    @Test
    public void test02() {
        System.out.println(switchit(4));
    }

    /**
     *  switch支持char short int byte 以及对应的包装类，枚举类，String,
     *  但String底层实际上调用hashCode方法，实际上还是int，包装类是因为能够进行自动拆箱。
     *  枚举类是因为有一个ordinal方法，该方法实际上是一个int类型的数值。
     * @param x
     * @return
     */
    public static int switchit(int x) {
        int j=1;
        switch (x) {
            case 1:j++;
            case 2:j++;
            case 3:j++;
            case 4:j++;
            case 5:j++;
            default:j++;
        }
        return j+x;
    }
}
