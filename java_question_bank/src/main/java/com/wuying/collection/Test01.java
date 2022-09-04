package com.wuying.collection;

import org.example.basis.A;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    @Test
    public void test01() {
        List list = new ArrayList<>();
        list.add(0);
        System.out.println(list.get(0).getClass());
        System.out.println(list.get(0) instanceof Integer);
    }
}
