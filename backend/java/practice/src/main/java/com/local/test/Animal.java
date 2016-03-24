package com.local.test;

public class Animal{
    protected void finalize(){
        System.out.println("an animal is destroyed");
    }
}
