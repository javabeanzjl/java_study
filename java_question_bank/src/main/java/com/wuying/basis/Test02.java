package com.wuying.basis;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Test02 {
    // 局部变量可以和成员变量重名，成员变量用this调用
    static int n = 0;
    int i = 0;
    /**
     * 在你面前有一个n阶的楼梯，你一步只能上1阶或2阶。
     * 请问，当N=11时，你可以采用多少种不同的方式爬完这个楼梯（）,当N=9时呢呢（）？
     * n = 1时，1 1种
     * n = 2时，11 2 2种
     * n = 3时，111 12 21 3种
     * n = 4时，121 112 211 1111 22 5种
     * n = 5时，11111 1112 2111 1211 1121 122 221 212 8种
     * n = 6时，111111 21111 11112 12111 11211 11121 2211 2121 2112 1221 1212 1122 222 13种
     * 每一次都等于前两次相加
     * f(3) = f(2) + f(1)
     * f(n) = f(n-1) + f(n-2)
     *
     */
    @Test
    public void test01() {
        // System.out.println(climb(9) + "||" +  climb(11));
        getSumMethods(9);
        getSumMethods(11);
    }
    public static int climb(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climb(n - 1) + climb(n - 2);
        }
    }
    private static Integer getSumMethods(int sum) {


        Map<String,Integer> map=new HashMap<>();
        map.put("1",1);
        map.put("2",2);

        for (int i=3;i<=sum;i++){

            Integer m1=i-1;
            Integer m2=i-2;
            Integer m1Value = map.get(String.valueOf(m1)) ;
            Integer m2Value = map.get(String.valueOf(m2))  ;
            map.put(String.valueOf(i),m1Value+m2Value);
        }
        System.out.println(map.toString());
        return  map.get(String.valueOf(sum));
        //{11=144, 1=1, 2=2, 3=3, 4=5, 5=8, 6=13, 7=21, 8=34, 9=55, 10=89}
    }
    
}
