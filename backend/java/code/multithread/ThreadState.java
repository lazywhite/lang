package multithread;
/*
 * ThreadState.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 * 线程的状态
 *      Thread.State(Enum)
 *          NEW
 *          RUNNABLE
 *          TERMINATED
 *          TIMED WAITING
 *          WAITING
 *          BLOCKED
 */
class MyService{
    synchronized static public void service(){
        try{
            System.out.println(Thread.currentThread().getName() + "进入了业务方法");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Bthread extends Thread{
    @Override
    public void run(){
        MyService.service();
    }
}

class Cthread extends Thread{
    @Override
    public void run(){
        String lock = new String();
        System.out.println("before sync block");
        synchronized (lock){
            System.out.println("entered sync block");
            try{
                lock.wait();
                System.out.println("after wait");//线程释放了对象锁, 在被notify之前, 不会执行到这里

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Athread extends Thread{
    public Athread(){
        System.out.println("线程初始化时的状态: " + Thread.currentThread().getState());
    }
    @Override
    public void run(){
        System.out.println("线程运行时的状态: " + Thread.currentThread().getState());
        try{
            Thread.sleep(200);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class ThreadState {

    public static void main(String[] args){
        try{
            Cthread ct = new Cthread();
            ct.start();
            Athread a = new Athread();
            System.out.println("线程新建后的状态: " + a.getState());
            a.start();
            Thread.sleep(100);
            System.out.println("线程运行时的状态: " + a.getState());
            Thread.sleep(300);
            System.out.println("线程结束后的状态: " + a.getState());

            Bthread b = new Bthread();
            b.setName("b");
            b.start();
            Thread.sleep(100);
            Bthread c = new Bthread();
            c.setName("c");
            c.start();
            Thread.sleep(100);
            System.out.println("等待其他线程执行同步方法时的线程状态: " + c.getState());
            System.out.println("等待其他线程通知的线程状态: " + ct.getState());
            //由于线程ct一直处在WAITING状态, 主进程无法退出
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

