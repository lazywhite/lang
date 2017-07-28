package multithread;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    /**
     * 计数器，用来控制线程
     * 传入参数2，表示计数器计数为2
     */
    private final static CountDownLatch mCountDownLatch = new CountDownLatch(2);

    /**
     * 示例工作线程类
     */
    private static class WorkingThread extends Thread {
        private final String mThreadName;
        private final int mSleepTime;
        public WorkingThread(String name, int sleepTime) {
            mThreadName = name;
            mSleepTime = sleepTime;
        }

        @Override
        public void run() {
            System.out.println("[" + mThreadName + "] started!");
            try {  
                Thread.sleep(mSleepTime);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }
            mCountDownLatch.countDown();
            System.out.println("[" + mThreadName + "] end!"); 
        }
    }

    /**
     * 示例线程类
     */
    private static class SampleThread extends Thread {

        @Override
        public void run() {
            System.out.println("[SampleThread] started!");
            try {
                // 会阻塞在这里等待 mCountDownLatch 里的count变为0；
                // 也就是等待另外的WorkingThread调用countDown()
                mCountDownLatch.await();
            } catch (InterruptedException e) {

            }
            System.out.println("[SampleThread] end!");
        }
    }

    public static void main(String[] args) throws Exception {
        // 最先run SampleThread
        new SampleThread().start();
        // 运行两个工作线程
        // 工作线程1运行5秒
        new WorkingThread("WorkingThread1", 5000).start();
        // 工作线程2运行2秒
        new WorkingThread("WorkingThread2", 2000).start();
    }
}

