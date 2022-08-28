package org.example.reflection;

import org.example.basis.Father;
import org.example.basis.Son;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test01 {
    // 反射
    // 作用1：在运行时判断一个对象所属的类
    @Test
    public void test01() throws ClassNotFoundException {
        Class father = Class.forName("org.example.basis.Father");
        // 运行时属于Son
        System.out.println(father.getClass().getSimpleName());
    }
    // 作用2： 在运行时构造一个类的对象,并判断所具有的方法和成员变量
    @Test
    public void test02() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("org.example.basis.Father");
        Father father = (Father) c.newInstance();
        Method[] methods = c.getMethods();
        Field[] fields = c.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field.getName());
        }
        for (Method m: methods) {
            // System.out.println(m.getName());
        }
    }
    // 作用3：在运行时调用一个对象的方法
    @Test
    public void test03() {
        try {
            Class c = Class.forName("org.example.basis.Father");
            Object obj = c.newInstance();
            Method testStatic = c.getDeclaredMethod("testStatic");
            testStatic.invoke(obj);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
