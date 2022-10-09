package com.wuying.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        try {
            int read = System.in.read();
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test01() {  
        Scanner s = new Scanner(System.in);
        String  str = s.next();
        System.out.println(str);
    }

    /**
     * 将文件中的内容输出到控制台。
     * 1、先创建User对象存到文件中。（序列化）
     * 2、再将文件中的内容输出到控制台。（反序列化）
     */
    // 序列化
    @Test
    public void test02() throws IOException {
        // 创建java对象
        User user = new User("张三","mrZ","123456",23);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("张三的信息"));
        oos.writeObject(user);
        oos.flush();
    }
    // 反序列化--将文件中的信息在控制台上显示。
    @Test
    public void test03() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("张三的信息"));
        User user = (User) ois.readObject();
        System.out.println(user);
    }
}
