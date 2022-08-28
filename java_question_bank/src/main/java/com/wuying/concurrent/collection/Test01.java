package com.wuying.concurrent.collection;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

public class Test01 {

    /**
     * 线程安全的集合ConcurrentHashMap
     */
    @Test
    public void test01() {
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("zhangsan",new String("lisi"));
        concurrentHashMap.put("zhangsan",new String("001"));// 键相同指挥覆盖掉。
        concurrentHashMap.put("lisi",new String("lisi"));// 键不同值相同并不会覆盖。
    }
}
