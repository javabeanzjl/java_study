package com.wuying.exception_log_duanyan.exception;

/**
 * 异常
 */
public class Test02 {
    // 方法上抛出异常
    public void test() throws Exception {
        
    }
    public void test01() {
        // try..catch捕捉异常
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void method1() {
        // 除数不能为0异常，不会报错:ArithemticException
        int result = 1 / 0;
        // 下标越界异常：ArrayIndexOutOfBoundsException
        int[] nums = new int[5];
        nums[6] = 10;
        // 空指针异常：NullPointerException
        String name = null;
        System.out.println(name.length());
        // 会抛出OutOfMemoryError;
        StringBuffer sb =new StringBuffer();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sb.append('a');
        }
    }
}
