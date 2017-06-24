package basic.generic;
/*
 * GenericClass.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

interface Throw<T>{
    public T throwOut();
}

class Service<T> implements Throw<T>{
    public T item;

    @Override 
    public T throwOut(){
        return this.item;
    }

    public Service(T item){
        this.item = item;
    }

}
public class GenericClass {
     
    public static void main(String[] args){
        Service<String> a = new Service<>("hello");
        System.out.println(a.throwOut());
        Service<Integer> b = new Service<>(10);
        System.out.println(b.throwOut());
    }
}

