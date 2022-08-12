package com.example.method_reference;

import java.util.ArrayList;
import java.util.List;

public class EmployData {
    
    public static List<Employ> getEmployees() {
        List<Employ> list = new ArrayList<>();
        list.add(new Employ(1001,10,"张三",1000.0));
        list.add(new Employ(1002,22,"张四s",2200.0));
        list.add(new Employ(1003,33,"张五ss",4400.0));
        list.add(new Employ(1004,12,"张流ssss",2300.0));
        list.add(new Employ(1005,24,"其s",2300.0));
        list.add(new Employ(1006,24,"张把ss2",10000.0));
        list.add(new Employ(1006,24,"李四23",10000.0));
        list.add(new Employ(1006,24,"网五222",10000.0));
        
        return list;
    }
}
