package com.wuying.collection.collection;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class Test01 {
    @Test
    public void test01() {
        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> subSet = new TreeSet<Integer>();
        for(int i=606;i<613;i++){
            if(i%2==0){
                set.add(i);
            }
        }
        // subSet(）方法：返回该集合的部分的视图，其元素的范围从 fromElement到 toElement。
        subSet = (TreeSet)set.subSet(608,true,611,true);
        set.add(609);
        // subSet是指向原集合的，所以原集合在这个范围内进行了修改，那么子集也会修改。
        System.out.println(set+" "+subSet);
    }
}
