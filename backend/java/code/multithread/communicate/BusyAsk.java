package multithread.communicate;
/*
 * BusyAsk.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 * 通过忙轮训, 可以达到线程间通信的目的, 但消耗大量cpu, 
 * 如果设置查询的间隔, 有可能拿不到正确的数据导致无法退出
 */
import java.util.*;
class MyList{
    private List list = new ArrayList<>();
    public void add(){
        list.add("test");
    }
    public int size(){
        return list.size();
    }
}

class Athread extends Thread{
    private MyList list;
    public Athread(MyList list){
        super();
        this.list = list;
    }

    @Override
    public void run(){
        try{
            for(int i=0;i<10;i++){
                list.add();
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(500);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Bthread extends Thread{
    private MyList list;

    public Bthread(MyList list){
        super();
        this.list = list;
    }

    @Override
    public void run(){
        System.out.println("thread b started");
        try{
            while(true){
                System.out.println(list.size());
                if(list.size() == 5){
                    throw new InterruptedException();
                }
            }
        }catch(InterruptedException e){
            System.out.println("list size is 5, exiting...");
            e.printStackTrace();
        }

    }

}
public class BusyAsk {

    public static void main(String[] args){
        try{

            MyList service = new MyList();
            Athread a = new Athread(service);
            Bthread b = new Bthread(service);
            a.setName("a");
            b.setName("b");

            a.start();
            b.start();
            a.join();
            b.join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

