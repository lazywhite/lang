package algorithm;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 8, 2, 5, 3, 7, 2, 9 };
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int start, int end){
        if(start >= end || arr.length == 1){
            return;
        }
        int middle = start + (end - start)/2;
        int pivot = arr[middle];
        int low = start;
        int high = end;
        while(high >= low){ //循环入口是可以相等的
            while(arr[low] < pivot){ //与key的比较不能相等
                low++;
            }
            while(arr[high] > pivot){
                high--;
            }
            if(high >= low){ //跟while循环入口一致, 可以相等
                int tmp;
                tmp = arr[low];
                arr[low++] = arr[high]; //隐含一次low的递增
                arr[high--] = tmp;
            }
        }//将比基准值小的全移动到左边, 大的全到右面
        if(start <= high){
            quickSort(arr, start, high);
        }
        if(end >= low){
            quickSort(arr, low, end);
        }

    }

}
