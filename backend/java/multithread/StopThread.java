/*
 * StopThread.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 * isInterrupted() 判断线程对象是否是中断状态, 但不清除状态标志
 * interrupted() 测试当前线程是否已经中断, 线程的中断状态由该方法清除
 */

class Athread extends Thread{
    @Override
    public void run(){
        super.run();
        for(int i=0;i<50000;i++){
            if(this.isInterrupted()){
                System.out.println("interrupted, stopping");
                break;
            }
            System.out.println("i=" + i);
        }
        System.out.println("如果这里是for循环, 又会执行, 线程不会终止");
    }
}

public class StopThread {

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

