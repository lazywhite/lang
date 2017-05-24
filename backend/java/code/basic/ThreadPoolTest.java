import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * Created by white on 17/5/24.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        run_cached_pool();
//        run_fixed_size_pool();

//        run_schedule_pool();
        run_single_pool();
    }

    public static void run_cached_pool(){
    //线程数量可变, 不足则新建, 空闲则回收
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0; i<10;i++){
            final int index = i;
            try{
                Thread.sleep(index * 1000);

            }catch(InterruptedException e){
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable(){
                public void run(){
                    System.out.println("current index is: " + index);
                }
            });
        }
    }
    public static void run_fixed_size_pool(){
        //同时执行的线程数量一定, 超出的线程在队列中等待
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            final int index = i;
            fixedThreadPool.execute(new Runnable(){
                public void run(){
                    try{
                        System.out.println(index);
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    public static void run_schedule_pool(){
        //支持定时任务和周期性任务
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);//池内的线程数量为5
        scheduledThreadPool.schedule(new Runnable(){ //在规定的时间之后, 仅执行一次, 相当于at
            public void run(){
                System.out.println("delayed 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);

        scheduledThreadPool.scheduleAtFixedRate(new Runnable(){ //在规定的时间后, 没隔interval执行一次 crontab
            public void run(){
                System.out.println("delayed 1 second, then execute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    public static void run_single_pool(){
        //用单线程执行任务, 保证任务按照FIFO的顺序执行
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for(int i=0; i<10; i++){
            final int index = i;
            singleThreadPool.execute(new Runnable(){
                public void run(){
                    try{
                        System.out.println(index);
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
