
import java.util.Arrays;
/**
 * 选择排序
 *
 */
public class SelectSort {
    public static void sort(int[] arr) {
        int temp;//定义一个临时变量
        for(int i=0;i<arr.length-1;i++){//选择次数
            int min = i;
            for(int j= i+1 ;j<arr.length;j++){
                if(arr[min] > arr[j]){
                    min = j; //记录当前最小数的下标
                }
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
