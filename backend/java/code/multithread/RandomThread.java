package multithread;
/*
 * RandomThread.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 * 此程序用来展示cpu执行哪个thread具有不确定性
 * 

 */

import java.util.*;

class MyThread extends Thread{
    @Override
    public void run(){
        try{
            for(int i=0;i<10;i++){
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

class IdThread extends Thread{
    private int i;
    public IdThread(int i){
        this.i = i;
    }

    @Override
    public void run(){
        System.out.println("this is thread " + this.i); 
    }
}

public class RandomThread {
    public static void randomSleep(){
        try{
            MyThread t = new MyThread();
            t.setName("m1");
            t.start();
            for(int i=0;i<10;i++){
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    } 
    /**
     * 执行start()方法的顺序不代表线程启动的顺序
     */
    public static void randomStart(){

        List<IdThread> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i, new IdThread(i));
        } 
        for(IdThread t: list){
            t.start();
        }
        
    }

    public static void main(String[] args){
//        randomSleep();
        randomStart();
    }
}


