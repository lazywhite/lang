package basic.generic;
/*
 * GenericMethod.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
class ArrayAlg{
    public static <T> T getMiddle(T... a){
        return a[a.length/2];
    }
}

public class GenericMethod {
    public static void main(String[] args){
        String middle = ArrayAlg.<String>getMiddle("bob", "john", "qoo");
        System.out.println(middle);
    }
}

