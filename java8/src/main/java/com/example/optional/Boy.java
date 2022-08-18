package com.example.optional;

import java.util.Objects;

public class Boy {
    private int id;
    private String name;
    private int age;
    private Girl girl;

    public Boy(String name) {
        this.name = name;
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", girl=" + girl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boy boy = (Boy) o;
        return id == boy.id && age == boy.age && Objects.equals(name, boy.name) && Objects.equals(girl, boy.girl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, girl);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public Boy(int id, String name, int age, Girl girl) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.girl = girl;
    }

    public Boy() {
    }
}
