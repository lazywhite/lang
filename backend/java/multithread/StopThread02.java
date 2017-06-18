/*
 * StopThread.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 * 停止线程的方法
 *      1. threadObj.interrupt()
 *      2. threadObj内部检查自己isInterrupted(), 如果为true则用throw exception 或者return退出线程
 */

class Athread extends Thread{
    @Override
    public void run(){
        super.run();
        try{

        for(int i=0;i<50000;i++){
            if(this.isInterrupted()){
                System.out.println("interrupted, stopping");
                throw new InterruptedException();
                //return;
            }
            System.out.println("i=" + i);
        }
        System.out.println("不会执行到这里,  线程终止");
        }catch(InterruptedException e){
            System.out.println("进main方法的catch");
            e.printStackTrace();
        }
    }
}

public class StopThread02 {

    public static void main(String[] args){
        try{
            Athread a = new Athread();
            a.start();
            Thread.sleep(100);
            a.interrupt();
            System.out.println("forth check: " + a.isInterrupted());
            System.out.println("forth check: " + a.isInterrupted());
        }catch(InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}

