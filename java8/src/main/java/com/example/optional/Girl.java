package com.example.optional;

import java.util.Objects;

public class Girl {
    private int id;
    private String name;
    private int age;
    private Boy boy;

    public Girl(String name) {
        this.name = name;
    }

    public Girl(Boy boy) {
        this.boy = boy;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", boy=" + boy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Girl girl = (Girl) o;
        return id == girl.id && age == girl.age && Objects.equals(name, girl.name) && Objects.equals(boy, girl.boy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, boy);
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

    public Boy getBoy() {
        return boy;
    }

    public void setBoy(Boy boy) {
        this.boy = boy;
    }

    public Girl(int id, String name, int age, Boy boy) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.boy = boy;
    }

    public Girl() {
    }
}
