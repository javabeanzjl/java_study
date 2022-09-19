package com.wuying.api.threadLocal;

import com.wuying.api.threadLocal.utils.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * ThreadLocal类详解
 */
public class Test01 {
    @Test
    public void test01() {
        System.out.println(DateUtil.parse("2022-09-19 18:20:30"));
        System.out.println(DateUtil.formateDateTime(new Date()));
    }
}
