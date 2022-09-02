package com.wuying.extend.classes;

import org.junit.jupiter.api.Test;

public abstract class Test01 {
    // 费非抽象类继承抽象类时必须实现抽象方法。而final修饰的类无法被继承。
    // abstract final void method();
}
// 抽象类就是用来被继承的，而final修饰的类无法被继承，显然final不能用于修饰抽象类。
// abstract final class Test02 { }

abstract class Test03 {
    // 抽象类只做声明不做实现。
    // public abstract void method() {};
}