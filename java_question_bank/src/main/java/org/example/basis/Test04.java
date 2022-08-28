package org.example.basis;

import org.junit.jupiter.api.Test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test04{
    
    // 测试继承之后的方法是否能够被调用，包括私有方法
    @Test
    public void test01() {
        
        try {
            // 获取子类对象
            Class c = Class.forName("org.example.basis.Son");
            // 得到父类
            Class superclass = c.getSuperclass();
            // 得到父类非继承的所有方法
            Method[] methods = superclass.getDeclaredMethods();
            // 设置私有方法可以被访问
            AccessibleObject.setAccessible(methods,true);
            for (Method m: methods) {
                System.out.println();
                System.out.println("子类调用方法" + m.getName() + "()的调用结果：");
                m.invoke(new Son());// 子类调用了父类的所有方法，说明子类可以
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
