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
}
