/*
 * StringSyncProblem.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 * 由于String常量池, 导致虽然是两个service对象, 但同在等待同一个"AA", b线程永远无法得到执行
 */
class Service{
    public  void print(String param){
        try{
            synchronized (param){
                while(true){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Athread extends Thread{
    Service service;
    String param;
    public Athread(Service s, String param){
        this.service = s;
        this.param = param;
    }

    @Override
    public void run(){
        service.print(param);
    }
}

public class StringSyncProblem {
     
    public static void main(String[] args){
        Service s1 = new Service();
        Service s2 = new Service();

        Athread a = new Athread(s1, "AA");
        Athread b = new Athread(s2, "BB");//线程相互独立
//        Athread b = new Athread(s2, "AA");//s2无法运行

        a.start();
        b.start();
    }
}

