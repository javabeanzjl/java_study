package com.wuying.extend;

public class User {
    public static String name = "张三";
    
    public static String passsword = "123456";

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }
}
