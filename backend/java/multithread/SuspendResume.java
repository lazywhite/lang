/*
 * SuspendResume.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 * suspend()挂起线程
 * resume()恢复线程
 *
 * suspend()后, 线程不会释放获得的锁, 在线程resume()之前, 别的线程无法拿到这个锁
 * suspend()之后, 如果没有事务保证, 则会造成数据不一致
 */

class MyService {
    synchronized public static void printString(){
        System.out.println("doing  service");

        try{

            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();

        }
        System.out.println("ending service");

    }
}

class Athread extends Thread{
    @Override
    public void run(){
        try{
            MyService.printString();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class SuspendResume {
    public static void main(String[] args){
        try{
            Athread a= new Athread();
            Athread b= new Athread();
            a.start();
            b.start();
            Thread.sleep(1000);
            a.suspend();
            Thread.sleep(1000);
            a.resume();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

