package com.local.entity;

/**
 * Created by white on 17/6/30.
 */
public class Person {
    private int id;
    private String name;
    private PersonAttr attr;

    public PersonAttr getAttr() {
        return attr;
    }

    public void setAttr(PersonAttr attr) {
        this.attr = attr;
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


}
