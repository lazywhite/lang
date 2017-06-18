/*
 * StopThrowLock.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 * stop()强制停止线程, 导致线程释放掉锁, 导致数据不一致
 */
class SynchronizedObj {
    private String username = "a";
    private String password = "aa";

    public void setUserName(String username){
        this.username = username;
    }
    public String getUserName(){
        return this.username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    synchronized public void printString(String username, String password){
        try{
            this.username = username;
            Thread.sleep(1000);
            this.password = password;

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}

class Athread extends Thread{
    private SynchronizedObj obj;
    private String str1;
    private String str2;
    public Athread(SynchronizedObj obj, String str1, String str2){
        super();
        this.obj = obj;
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public void run(){
        obj.printString(this.str1, this.str2);
    }
}

public class StopThrowLock {
    public static void main(String[] args){
        try{
            SynchronizedObj obj = new SynchronizedObj();
            Athread a = new Athread(obj, "b", "bb");
            a.start();
            Thread.sleep(10);
            a.stop();
            System.out.println(obj.getUserName() + " " + obj.getPassword());
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

