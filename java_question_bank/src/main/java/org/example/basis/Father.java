package org.example.basis;

public class Father {
    public String name; 
    public Father() {
        System.out.println("调用父类的构造器");
    };
    
    private static void testStaticPrivate() {
        System.out.println("静态私有方法被调用");
    }
    
    public static void testStatic() {
        System.out.println("静态方法被调用");
    }
    
    public final void testFinal() {
        System.out.println("final方法被调用");
    }
    private void testPrivate() {
        System.out.println("私有方法被调用");
    }
}
