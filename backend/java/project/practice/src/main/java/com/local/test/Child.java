package com.local.test;
public class Child extends Father {
    public Integer age;
    public Child(String name, Integer age){
        super(name); // call super contructor
        this.age = age;
    }


    public void say(){
        super.say(); // call super method
        System.out.println("child say");
    }
}
