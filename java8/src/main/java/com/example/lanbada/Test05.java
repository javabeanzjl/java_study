package com.example.lanbada;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Test05 {
    @Test
    public void test01() {
        File file = new File("D:\\java\\java_study\\java8\\src\\main\\java\\com\\example\\lanbada");
        File[] files1 = file.listFiles((File a) -> a.getName().endsWith(".java"));
        for (File f: files1) {
            System.out.println(f.getName());
        }
        File[] files2 = file.listFiles(a -> a.getName().endsWith(".java"));
        for (File f: files2) {
            System.out.println(f.getName());
        }
    }
}
