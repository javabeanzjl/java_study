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
