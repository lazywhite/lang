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
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr) {
        int j, key, tmp;
        int len = arr.length;
        for(int i=1;i<len;i++){
            j = i - 1;
            key = arr[i];
            while(j>=0 && arr[j] >= key){ //碰到相等的数继续往下走
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
