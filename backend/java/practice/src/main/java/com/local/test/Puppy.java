package com.local.test;

public class Puppy extends Animal{
    String puppyName;
    int puppyAge;
    public Puppy(String name){
        System.out.println("A new puppy is born");
    }
    public void setAge(int age){
        puppyAge = age;
    }
    public int getAge(){
        return puppyAge;
    }
}

