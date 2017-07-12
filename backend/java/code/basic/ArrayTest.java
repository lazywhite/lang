package basic;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Collection;
import java.util.Random;
import java.util.Iterator;

/* 数组
 *  动态赋值: 开辟新空间
 *  静态赋值: 不开辟新空间， 数组长度跟原来一样
 */

public class ArrayTest {
	public static void main(String[] args){
		int[] arr = new int[10]; //声明固定长度的数组
        //如果不初始化, 会有默认值, 视数据类型而定
		System.out.println(arr[2]);

        int[] arr1; //声明数组
		arr1 = new int[]{3, 2, 1}; //进行动态赋值 
		arr1 = new int[]{8, 2, 1, 9, 3, 5, 6}; //重复进行动态赋值 
        int[] arr2 = { 9, 7, 4 };//静态赋值
//        arr2 = { 5, 6, 7 }; //无法二次静态赋值
        int[] arr8 = arr1;//arr8是arr1的别名, 指向同一个数组 
        Arrays.sort(arr1); //must sort array before use binarySearch()
        int index = Arrays.binarySearch(arr1, 1);//return -1 if not found
        System.out.println("index of number 1 is " + index);

        int[] arr3 = arr1.clone(); //第三种数组复制
        System.out.println("elements are same: " + Arrays.equals(arr1, arr3));
        System.out.println("reference is same: " + (arr1 == arr3));
        int[] arr5 = Arrays.copyOf(arr3, 10);//大于原始长度的元素, 用0填充
//        Arrays.fill(arr5, 8);//将数组所有元素替换为8
        System.out.println("arr5: " + Arrays.toString(arr5));

        //多维数组声明
        int[][] arr4 = new int[][]{{1, 2, 3}, {4, 5, 6}};

        int[] arr7 = Arrays.copyOf(arr1, 3);//第一种数组复制
        int[] arr6 = new int[10];
        System.out.println("arr7: " + Arrays.toString(arr7));
        System.arraycopy(arr1, 1, arr6, 3, 4);//第二种数组复制
        System.out.println("arr6: " + Arrays.toString(arr6));

        String[] phones = {"iphone4", "iphone5", "iphone6", "iphone7"};
        removeElement(phones, "iphone5");
//        updateElement(phones, "iphone5", "小米");
        addElement(phones, "华为");
	}


    public static void removeElement(String[] arr, String str) throws ArrayIndexOutOfBoundsException{
        int index = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(str)){
                index = i;
                break;
            }
        }
        for(int j=index;j<arr.length-1;j++){
            arr[j] = arr[j+1];
        }
        arr[arr.length-1] = null;
        System.out.println(Arrays.toString(arr));
             
    }

    public static void updateElement(String[] arr, String oldStr, String newStr){
        int index = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(oldStr)){
                arr[i] = newStr;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void addElement(String[] arr, String str){
        int index = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == null){
                index = i;
//                arr[i] = str;
            }
        }
        if(index >0){
            arr[index] = str;
        }else{
            System.out.println("数组已满");
        }
        System.out.println(Arrays.toString(arr));
    }
}
