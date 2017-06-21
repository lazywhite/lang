/*
 * LockSimple.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;//可重入锁
class Service{
    private Lock lock = new ReentrantLock();
    public void printOut(){
        lock.lock();
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        lock.unlock();
    }
}
class Athread extends Thread{
    private Service service;
    public Athread(Service service){
        super();
        this.service = service;
    }
    @Override
    public void run(){
        service.printOut();
    }
}
public class LockSimple {
     
    public static void main(String[] args){
        Service s = new Service();
        Athread a1 = new Athread(s);
        Athread a2 = new Athread(s);
        Athread a3 = new Athread(s);
        Athread a4 = new Athread(s);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }
}

