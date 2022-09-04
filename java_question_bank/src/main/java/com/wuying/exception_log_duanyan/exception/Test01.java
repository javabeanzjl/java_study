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
    @Test
    public void test02() {
        try {
            System.out.println(1/0);
        } catch (Exception e) {
            System.out.println("发生异常");
            return;
        } finally {
            System.out.println("finally仍然执行");
        }
        // 由于发生异常且catch块中有return所以并不执行
        System.out.println("11");
            
    }
}
