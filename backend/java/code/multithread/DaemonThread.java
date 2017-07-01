package multithread;
/*
 * DaemonThread.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 * 
 * 用户线程退出, 则守护线程自动退出
 */

class Daemon extends Thread{
    @Override
    public void run(){

        try{
            int i = 0;
            while(true){
                System.out.println("i=" + i);
                i++;
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("exiting daemon thread");
            e.printStackTrace();
        }
    }
}
public class DaemonThread {

    public static void main(String[] args){
        try{
            Daemon a = new Daemon();
            a.setDaemon(true);
            a.start();
            Thread.sleep(3000);
            System.out.println("exiting user thread");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

