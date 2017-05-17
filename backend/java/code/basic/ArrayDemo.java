import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class ArrayDemo {
	public static void main(String[] args){
		int[] arr = new int[10]; //声明固定长度的数组
		for(int i=0;i<arr.length;i++){
			Random r = new Random();
			arr[i] = r.nextInt(100);
			
		}
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr); //数组排序
        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));

		int[] arr1;
		arr1 = new int[]{3, 2, 1}; //先声明， 后赋值

		String[] arr2 = {"hello", "world"}; //声明同时赋值
		System.out.println(Arrays.toString(arr2));

        int[] arr3 = arr1.clone();
        System.out.println(Arrays.toString(arr3));
        //多维数组声明及遍历
        int[][] arr4 = new int[][]{{1, 2, 3}, {4, 5, 6}};

        for(int i=0;i<arr4.length;i++){
            for(int j=0;j<arr4[i].length;j++){
                System.out.println(arr4[i][j]);
            }
        }


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
