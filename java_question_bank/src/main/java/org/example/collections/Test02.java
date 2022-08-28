package org.example.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test02 {
    // 测试迭代器Iterator的remove方法
    @Test
    public void test01() {
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        Iterator it =  collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            System.out.println("删除前集合中的元素个数" + collection.size());
            it.remove();
            System.out.println("删除后集合汇总的元素个数" + collection.size());
        }
    }
}
