
/**
 * Created by white on 17/5/21.
 *
 * yield(): 主动切换当前线程的执行
 * sleep(): 暂停当前线程的执行
 * t.join(): 等待t线程执行结束
 * t.stop(): 强制结束t线程
 * t.interrupt(): 结束t进程
 * Thread.MAX_PRIORITY  一般为10
 * Thread.MIN_PRIORITY 一般为1
 * 优先级高的线程优先被执行
 *
 * user thread: 可以理解为前台线程
 * daemon thread: 后台线程
 * 如果所有的user thread已经退出, 只剩下daemon thread, 则jvm会退出
 */

class Thread01 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println("type thread01: " + i);
        }
    }
}

class Thread02 implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println("type thread02: " + i);
        }
    }
}


class Thread03 extends Thread{
    private String name;
    public Thread03(String name){
        super();
        this.name = name;
    }
    @Override
    public void run(){
        System.out.println("type thread03: " + this.name + "before yield ");
        Thread.yield();
        System.out.println("type thread03: " + this.name + "after yield ");
    }
}

class Thread04 extends Thread {
    private int t;
    private String name;
    public Thread04(int t, String name){
        super();
        this.t = t;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(this.t);
                System.out.println("type thread04: " + this.name + " " + i);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        try{
//        Thread01 t1 = new Thread01();
//        Thread01 t2 = new Thread01();
//        t1.start();
//        t2.start();
//        Thread t3 = new Thread(new Thread02());
//        t3.start();
            Thread t4 = new Thread03("t4");
            Thread t5 = new Thread03("t5");
            t4.setPriority(10); //设置线程优先级
            t5.setPriority(1);
            t4.start();
            t5.start();
            System.out.println(Thread.MAX_PRIORITY);
            System.out.println(Thread.MIN_PRIORITY);

//            Thread.sleep(3000); //主线程睡眠, 单位毫秒
//            Thread t6 = new Thread04(3000, "t6");
//            Thread t7 = new Thread04(6000, "t7");
//            t6.start();
//            t7.start();
//            t6.join();//让主线程等待此线程结束
//            t7.join();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
