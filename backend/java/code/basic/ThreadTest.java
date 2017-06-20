import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * 线程优先级
        Thread.MAX_PRIORITY
        Thread.MIN_PRIORITY
        Thread.Norm_PRIORITY
 * 创建线程的三种方式
 * 1. 调用callable, 实现call(), 可以有返回值
 * 2. 调用runable, 实现run(), 不能有返回值
 * 3. 继承thread, 重写run(), 不能有返回值
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

class Thread03 implements Callable<String> {//String is return type
    private int id;
    public Thread03(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception{
        return "result of Thread03: " + this.id;
    }
}
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        try{
            Thread01 t1 = new Thread01();
            t1.start();
            Thread t2 = new Thread(new Thread02());
            t2.start();

            ExecutorService  pool = Executors.newFixedThreadPool(3);
            ArrayList<Future<String>> results = new ArrayList<Future<String>>();
            for(int i=0;i<10;i++){
                results.add(pool.submit(new Thread03(i))); //submit a value-return task and return a Future
            }
            Thread.sleep(1000);
            for(Future<String> fs: results){
                if(fs.isDone()){
                    System.out.println(fs.get());
                }else{
                    System.out.println("future result is not completed");
                }
            }
            pool.shutdown();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
