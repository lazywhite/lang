/*
 * StartOrRun.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 * 线程自动得到类似于 Thread-0, Thread-1的名字
 *
    start() 和 run()的区别
        thread.start()方法通知线程调度器自己处于就绪状态， 等待调用自己的run()方法
        具有异步执行的效果
        而直接调用thread.run()就不是异步执行， 而是同步执行， 此线程对象并不交给线程调度器处理， 而是由主线程调用run()方法，没有多线程效果
 */
class Athread extends Thread{
    public Athread(){
        System.out.println("构造方法的打印: " + Thread.currentThread().getName());
    }
    @Override
    public void run(){
        System.out.println("run方法的打印: " + Thread.currentThread().getName());
    }
}

public class StartOrRun {
     
    public static void main(String[] args){
        Athread a = new Athread();
        Athread b = new Athread();
        a.start();
        b.start();
//        a.run();

    }
}

