package multithread;
/*
 * ClassLock.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 * synchronized 修饰静态方法, 相当于加类锁, 如果一个线程执行一个对象A的sync static方法, 另一个线程执行B的sync static方法
 *  如果 A,B属于同一个类, 则另一个线程必须阻塞等待第一个线程执行完毕
 */
class Service{
    synchronized public static void printA(){
        try{
            System.out.println("thread name: " + Thread.currentThread().getName() + " enter at " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("thread name: " + Thread.currentThread().getName() + " leave at " + System.currentTimeMillis());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Athread extends Thread{
    public Service service;
    public Athread(Service s){
        this.service = s;
    }
    @Override
    public void run(){
        service.printA();
    }
}

public class ClassLock {
    public static void main(String[] args){
        Service s1 = new Service();
        Service s2 = new Service();
        Athread a = new Athread(s1);
        Athread b = new Athread(s2);
        a.start();
        b.start();
    }
}

