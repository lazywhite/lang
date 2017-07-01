package multithread.communicate;
/*
 * AutoAwake.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 * wait(time) 在time后自动唤醒, 进行锁竞争
 *
 */
class Athread extends Thread{
    private Object lock;
    private int waitTime;
    public Athread(Object lock, int waitTime){
        super();
        this.lock = lock;
        this.waitTime = waitTime;
    }

    @Override
    public void run(){
        try{

            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + " before wait");
                lock.wait(waitTime);//停止一段时间后自动唤醒, 参与到锁竞争
                System.out.println(Thread.currentThread().getName() + " after wait");
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}


class Cthread extends Thread{
    private Object lock;
    public Cthread(Object lock){
        super();
        this.lock = lock;
    }

    @Override
    public void run(){
        try{

            synchronized (lock){
                while(true){
                    // hold lock forever;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

public class AutoAwake {
    public static void main(String[] args){
        try{
            Object lock = new Object();
            Athread a1 = new Athread(lock, 3000);
            a1.setName("a1");
            a1.start();
            Cthread c1 =  new Cthread(lock);
            c1.start();
            //a1永远无法执行wait()后的代码, 因为拿不到对象锁

        }catch(Exception e){
            e.printStackTrace();
        }
    }
     
}
