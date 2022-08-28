package org.example.design_pattern;

// 单例模式--饿汉式
public class SingletonPattern_hungry {
    // 4、在类加载时进行初始化。
    private static SingletonPattern_hungry sp = new SingletonPattern_hungry();
    
    // 1、构造器私有化,禁止外部调用创建对象
    private SingletonPattern_hungry() {}
    
    // 2、创建静态方法让外部获取本类的实例对象，由于没有对象使用所以采用类方法及静态方法。
    public static SingletonPattern_hungry getInstance() {
        // 3、同过方法返回实例对象，类方法只能调用静态方法
        return sp;
    }
}
