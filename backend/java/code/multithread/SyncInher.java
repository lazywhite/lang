package multithread;
/*
 * SyncInher.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 * 子类async方法调用父类sync方法, 只有父类的同步才有效果, 
 */

class Main{
    synchronized public void printString(){
        try{
            System.out.println("starting main service"); 
            Thread.sleep(5000);
            System.out.println("ending main service");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Sub extends Main{
    public void doService(){
        System.out.println("starting sub service");
        try{
            Thread.sleep(1000);
            super.printString();
            Thread.sleep(1000);
            System.out.println("ending sub service");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Athread extends Thread{
    public Sub sub;
    public Athread(Sub sub){
        super();
        this.sub = sub;
    }
    @Override
    public void run(){
        this.sub.doService();
    }
}
public class SyncInher {

    public static void main(String[] args){
        Sub sub = new Sub();
        Athread a = new Athread(sub);
        Athread b = new Athread(sub);
        a.start();
        b.start();
    }
}

