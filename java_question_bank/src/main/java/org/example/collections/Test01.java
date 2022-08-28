package org.example.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Test01 {
    
    @Test
    public void test01() {
        List<String> list = new ArrayList<String>() {
            @Override
            public int hashCode() {
                return 1;
            }
        };
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };
        Supplier<String> stringSupplier = () -> {
            return "null";
        };
        stringSupplier.get();
    }
}
