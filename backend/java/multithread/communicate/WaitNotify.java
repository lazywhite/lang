/*
 * WaitNotify.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 * 线程调用对象的wait()方法时, 必须获得对象锁, 即只能在
 * 同步方法或同步块中调用, 在执行完wait()后, 当前线程释放锁, 
 * 在从wait()返回前, 线程与其他线程竞争重新获得锁.
 *
 * 如果没有获得对象锁就调用wait()则抛出IllegalMonitorStateException
 *
 * notify()在调用前也需要获得对象锁, 没锁则抛出IllegalMonitorStateException, 该
 * 方法用来通知那些可能等待该对象锁的其他线程, 如果有多个线程, 则由线程规划器
 * 随机选择一个线程, 对其发出通知
 *
 * notify()方法执行完后, 当前线程不会马上释放对象锁, 需要等待执行notify()方法的线程
 * 退出同步代码块后才会释放, 其他线程才会有机会获得该对象锁
 *
 * 当第一个获得该对象锁的wait线程执行完同步代码块, 他会释放掉该锁, 此时如果该对象
 * 没有再次使用notify(), 则即使该对象锁已空闲, 由于其他wait状态的线程没有得到该
 * 对象通知, 还会继续阻塞在wait状态, 直到这个对象发出notify()或notifyAll()
 *
 * 线程A处在WAITING状态执行A.interrupt(), 会出现InterruptedException, 进入catch块
 *
 * 如果在wait()之前, 别的线程已经notify()过了, 则notify()无效
 */

class Athread extends Thread{
    private Object lock;
    private int waitTime;
    public Athread(Object lock){
        super();
        this.lock = lock;
    }

    @Override
    public void run(){
        try{

            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + " before wait");
                lock.wait();//调用wait()后立即释放对象锁,其他线程可竞争到
                System.out.println(Thread.currentThread().getName() + " after wait");
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Bthread extends Thread{
    private Object lock;
    public Bthread(Object lock){
        super();
        this.lock = lock;
    }

    @Override
    public void run(){
        try{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + " before notify");
                lock.notifyAll();//等待对象锁的全部线程都会被通知
//                lock.notify();//只有一个线程被通知, 其他一直阻塞
                System.out.println(Thread.currentThread().getName() + " notified but sleeping");//notify()之后不立即释放锁, 直到同步块执行完毕
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " after notify");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


public class WaitNotify {
    public static void main(String[] args){
        try{
            Object lock = new Object();
            Athread a1 = new Athread(lock);
            a1.setName("a1");
            Athread a2 = new Athread(lock);
            a2.setName("a2");
            Bthread b1 = new Bthread(lock);
            b1.setName("b1");

            a1.start();
            Thread.sleep(1000);
            a2.start();//a1 wait()之后释放了锁, 所以a2可以拿到锁并执行到自己的wait()之前
            Thread.sleep(3000);
            b1.start();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}

