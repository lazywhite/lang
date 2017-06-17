/*
 * User.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
package com.local;
import  java.io.Serializable;

public class User implements Serializable{
    private String name;
    public User(){
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

}

