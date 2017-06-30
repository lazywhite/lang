package com.local.entity;


/**
 * Created by white on 17/6/30.
 */

public class PersonAttr {
    private int id;
    private String attr;
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public PersonAttr() {

    }
}
