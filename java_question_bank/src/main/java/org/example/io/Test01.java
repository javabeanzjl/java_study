package org.example.io;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Test01 {
    // 序列化
    @Test
    public void test01() {
        // 先序列化
        // 创建java对象
        User user = new User("zhang","mr","123456",23);

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("zhangsan"));
            oos.writeObject(user);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    // 反序列化
    @Test
    public void test02() {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("zhangsan"));
            User user = (User) ois.readObject();
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
