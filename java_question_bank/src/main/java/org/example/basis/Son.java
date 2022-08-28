package org.example.basis;

public class Son extends Father{
    
    private String name;
    public Son() {
    }
    public Son(String name) {
        this.name = name;
    }
    public void printSon() {
        System.out.println("调用子类公有方法");
    }
}
