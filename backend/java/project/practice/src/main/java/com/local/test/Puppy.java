package com.local.test;

public class Puppy extends Animal{
    String name;
    int age;
    public Puppy(String puppyName){
        this.name = puppyName;
        System.out.println("A new puppy is born");
    }
    public void setAge(int age){
        this.age =  age;
    }
    public int getAge(){
        return age;
    }
}

