/*
 * ProducerConsumer.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 * 一生产, 一消费, 操作值
 */
class ValueContainer{
    public static String value = "";
}
class Producer {
    private Object lock;
    public Producer(Object lock){
        this.lock = lock;
    }

    public void setValue(){
        try{

            synchronized (lock){
                if(!"".equals(ValueContainer.value)){
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "";
                System.out.println("set value");
                ValueContainer.value = value;
                lock.notify();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

class Consumer {
    private Object lock;
    public Consumer(Object lock){
        this.lock = lock;
    }

    public void getValue(){
        try{

            synchronized (lock){
                if("".equals(ValueContainer.value)){
                    lock.wait();
                }
                System.out.println("get value: " + ValueContainer.value);
                ValueContainer.value = "";
                lock.notify();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
class Athread extends Thread{
    private Producer p;
    public Athread(Producer p){
        this.p = p;
    }
    @Override
    public void run(){
        while(true){
            p.setValue();

        }
    }
}
class Bthread extends Thread{
    private Consumer c;
    public Bthread(Consumer c){
        this.c = c;
    }
    @Override
    public void run(){
        while(true){
            c.getValue();
        }
    }
}
public class ProducerConsumer {

    public static void main(String[] args){
        Object o = new Object();
        Producer p = new Producer(o);
        Consumer c = new Consumer(o);
        Athread a = new Athread(p);
        Bthread b = new Bthread(c);
        a.start();
        b.start();
    }
}

