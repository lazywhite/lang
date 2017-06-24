package algorithm;
import java.util.Arrays;
/**
 * 把剩下的元素中的最小值交换到当前位置
 */
public class SelectSort {
    public static void sort(int[] arr) {
        int temp;//定义一个临时变量
        for(int i=0;i<arr.length-1;i++){//选择次数
            int min = i;
            for(int j= i+1 ;j<arr.length;j++){
                min = (arr[j] < arr[min])?j:min;
            }
            if(min != i){
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,6,2,2,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
