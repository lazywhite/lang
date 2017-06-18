/*
 * ShareData.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 * synchronized可以在任意方法或对象上加锁,加锁后的这段代码称为
 * 互斥区或临界区
 *
 */
class Bthread extends Thread{
    private int count = 5;
    @Override
    public void run(){
        count--;
        System.out.println("由" + this.currentThread().getName() + " 计算count=" + count);
    }
}

class Cthread extends Thread{
    private int count = 5;
    /**
     * 确保run()方法是顺序执行的
     * 当一个线程执行run()方法之前, 先判断有没有加锁, 如果上锁就
     * 等待其他线程释放锁, 达到排队执行的效果
     *
     * 多个线程同时竞争去拿锁, 每个线程忙轮询检查锁是否释放
     *
     */
    @Override
    synchronized public void run(){
        count--;
        System.out.println("由" + this.currentThread().getName() + " 计算count=" + count);
    }
}

public class ShareData {

    public static void noSync(){
        Bthread B = new Bthread();
        Thread a = new Thread(B, "A");
        Thread b = new Thread(B, "B");
        Thread c = new Thread(B, "C");
        Thread d = new Thread(B, "D");
        Thread e = new Thread(B, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }
    /**
     * 多个线程对共享资源操作, 产生"非线程安全"问题
     */
    public static void sync(){
        Cthread C = new Cthread();
        Thread a = new Thread(C, "A");
        Thread b = new Thread(C, "B");
        Thread c = new Thread(C, "C");
        Thread d = new Thread(C, "D");
        Thread e = new Thread(C, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
    public static void main(String[] args){
        sync();
        //        noSync();
    }
}

