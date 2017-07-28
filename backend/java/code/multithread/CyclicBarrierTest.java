package multithread;
import java.util.concurrent.*;
import java.util.*;
//多线程算法对象，内部定义了一些静态方法，均用多线程实现
public class CyclicBarrierTest {
    public static void shellSort(int[] a, int threadCount) {
        List<Integer> gaps = new ArrayList<>();
        CyclicBarrier barrier = new CyclicBarrier(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        int gap = a.length/2;
        while(gap>=1) {  //希尔排序步长的选择是最基本的... 8,4,2,1
            gaps.add(gap);
            gap /= 2;
        }
        for(int i=0; i<threadCount; i++) {
            new ShellSortThread(i, threadCount, barrier, gaps, latch, a).start();
        }
        try {
            latch.await();  //在多线程排序时，用此门闩将主线程阻塞，直到排序结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        int[] arr  = {9, 5, 2, 1, 3, 8};
        shellSort(arr, 3);
        System.out.println(Arrays.toString(arr));
            
    }
}

//负责排序的线程
class ShellSortThread extends Thread {

    private int threadID;   //当前线程的编号，取值为 0, 1, 2, 3 ...
    private int threadSum;  //开启的线程总数
    private CyclicBarrier barrier;  //设置执行中间点
    private List<Integer> gaps;   //希尔排序的步长序列
    private CountDownLatch latch;   //用于阻塞主线程，与希尔排序算法无关
    private int[] a;    //待排序的数组

    public ShellSortThread(int threadID, int threadSum, CyclicBarrier barrier,
            List<Integer> gaps, CountDownLatch latch, int[] a) {
        super();
        this.threadID = threadID;
        this.threadSum = threadSum;
        this.barrier = barrier;
        this.gaps = gaps;
        this.latch = latch;
        this.a = a;
    }

    /*
     * 算法思想：希尔排序原理是利用步长将原序列划分为多个子序列，对每个子序列进行插入排序
     * 例如，若步长为8，则划分为8个子序列，并且这些子序列是互不相关的，
     * 因此，可以使用多线程来对这些子序列进行插入排序，不存在同步问题。
     * 例如，开6个线程进行排序，当步长为20时，
     * 第1个线程负责第1,7,13,19个子序列的排序，
     * 第2个线程负责第2,8,14,20个子序列的排序，
     * ......
     * 第6个线程负责第6,12,18个子序列的排序
     * 每个线程使用当前步长排序结束后，调用CyclicBarrier对象的await()方法等待其他线程
     * 当所有线程都使用当前步长排序结束后，CyclicBarrier闸门打开，更改步长，重复上面的步骤排序
     * 当步长减少到1时，只有第1个线程进行插入排序，其他线程空转，直接await()
     * 最后，排序结束
     */
    @Override
    public void run() {
        for(int i=0, gap; i<gaps.size(); i++) {
            gap = gaps.get(i);
            for(int sub_array_index = threadID; sub_array_index<gap; sub_array_index += threadSum) {
                for(int j=sub_array_index+gap; j<a.length; j += gap) {
                    int temp = a[j];
                    int k;
                    for(k=j-gap; k>=0 && a[k] > temp; k -= gap) {
                        a[k+gap] = a[k];
                    }
                    a[k+gap] = temp;
                }
            }
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                //若发生异常，必须修改latch后退出，否则主线程会永远阻塞
                latch.countDown();
                return;
            }
        }
        latch.countDown();
    }
}
