package com.example.method_reference;

import java.util.Objects;

public class Employ {
    private int id;
    private int age;
    private String name;
    private double salary;

    public Employ() {
    }

    @Override
    public String toString() {
        return "Employ{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employ employ = (Employ) o;
        return id == employ.id && age == employ.age && Double.compare(employ.salary, salary) == 0 && Objects.equals(name, employ.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, salary);
    }

    public Employ(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employ(int id, int age, String name, double salary) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.salary = salary;
    }
}
