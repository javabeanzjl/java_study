package com.wuying.extend.reflection;

import com.wuying.extend.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class Test01 {
    
    // 用反射获取User对象里面的static属性的值
    @Test
    public void test01() {
        try {
            String name = (String) User.class.getField("name").get(null);
            String name1 = (String) User.class.getDeclaredField("name").get(null);
            System.out.println(name1);
            System.out.println(name);
            Field[] fields = User.class.getFields();
            for (Field field: fields) {
                System.out.println(field.get(null));
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
