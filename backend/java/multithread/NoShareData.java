/*
 * NoShareData.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 * 每个线程都有自己专属的数据, 互不影响
 */
class AThread extends Thread{
    private int count = 5;
    public AThread(String name){
        super();
        this.setName(name);
    }
    @Override
    public void run(){
        super.run();
        while(count > 0){
            count--;
            System.out.println("thread: " + this.currentThread().getName() + " 计算: " + count);
        }
    }
}

public class NoShareData {
     
	public NoShareData() {
	}
    public static void main(String[] args){
        AThread a = new AThread("A");
        AThread b = new AThread("B");
        AThread c = new AThread("C");
        a.start();
        b.start();
        c.start();
    }
}

