package com.pzz.entity;


public class Dog {
    private Integer id;
    private String name;
    private String info;

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Dog() {
    }

    public Dog(Integer id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }
}
