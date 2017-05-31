import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 8, 2, 5, 3, 7, 2, 9 };
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int start, int end){
        if(start >= end || arr.length == 0){
            return;
        }
        int middle = start + (end - start)/2;
        int pivot = arr[middle];
        int low = start;
        int high = end;
        while(high >= low){
            while(arr[low] < pivot){
                low++;
            }
            while(arr[high] > pivot){
                high--;
            }
            if(high >= low){
                int tmp;
                tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
                low++;
                high--;
            }
            if(start < high){
                quickSort(arr, start, high);
            }
            if(end > low){
                quickSort(arr, low, end);
            }
        }

    }

}
