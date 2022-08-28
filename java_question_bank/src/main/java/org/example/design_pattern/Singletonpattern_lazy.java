package org.example.design_pattern;

// 单例模式--懒加载
public class Singletonpattern_lazy {
    
    private static Singletonpattern_lazy singletonpattern_lazy;
    
    // 构造器私有化
    private Singletonpattern_lazy() {}
    
    public static Singletonpattern_lazy getInstance() {
        if (singletonpattern_lazy == null) {
            singletonpattern_lazy = new Singletonpattern_lazy();
        }
        return singletonpattern_lazy;
    }
    
    public void test() {
        System.out.println("这时单例模式懒汉式");
    }
    
    
}
