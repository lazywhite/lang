import java.util.Arrays;
/**
 * Created by white on 17/5/20.
 * 插入排序
 *      向已排好序的队列插入新元素, 比插入元素大的所有元素需要依次后移
 *      初始第一个元素视为已排序队列
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5};
        int start = 0;
        int end = a.length - 1;
        System.out.println(Arrays.toString(a));
        sort(a, start, end);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr, int start, int end) {
        for(int i=1;i<end;i++){
            int j = i - 1;
            while(j>=0 && arr[j] > arr[j+1]){
                int tmp;
                tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
                j--;
            }
        }
    }
}
