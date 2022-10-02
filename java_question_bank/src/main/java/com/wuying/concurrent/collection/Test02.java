package com.wuying.concurrent.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class Test02 {
    @Test
    public void test01() {
        Collection<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Collection<Integer> list2 = new ArrayList<>();
        list2.add(1);
        // 判断集合是否完全包含另一个集合的所有元素。
        System.out.println(list.containsAll(list2));
    }
}
