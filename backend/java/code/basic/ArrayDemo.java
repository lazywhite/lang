import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Collection;
import java.util.Random;
import java.util.Iterator;


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
        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));

        List<Integer> arrList = new ArrayList<Integer>();
        arrList.add(3);
        arrList.add(8);
        arrList.add(13);
        arrList.add(9);
        Collections.shuffle(arrList); //打乱元素顺序, 仅接受List<T>型参数
        for(Integer i: arrList){
            System.out.print(i + " ");
        }

		int[] arr1;
		arr1 = new int[]{3, 2, 1}; //先声明， 后赋值
        Arrays.sort(arr1); //must sort array before use binarySearch()
        int index = Arrays.binarySearch(arr1, 1);//return -1 if not found
        System.out.println("index of number 1 is " + index);

		String[] arr2 = {"hello", "world"}; //声明同时赋值
		System.out.println(Arrays.toString(arr2));

        int[] arr3 = arr1.clone();
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.equals(arr1, arr3));// Arrays.equals(arr1, arr2)
        int[] arr5 = Arrays.copyOf(arr3, 5);//大于原始长度的元素, 用0填充
        Arrays.fill(arr5, 8);//将数组所有元素替换为8
        System.out.println(Arrays.toString(arr5));
        //多维数组声明及遍历
        int[][] arr4 = new int[][]{{1, 2, 3}, {4, 5, 6}};

        System.out.println("开始遍历多维数组");
        for(int i=0;i<arr4.length;i++){
            for(int j=0;j<arr4[i].length;j++){
                System.out.println(arr4[i][j]);
            }
        }
        System.out.println("结束遍历多维数组");


        String[] phones = {"iphone4", "iphone5", "iphone6", "iphone7"};
        removeElement(phones, "iphone5");
//        updateElement(phones, "iphone5", "小米");
        addElement(phones, "华为");


        // 用迭代器进行数组遍历
        ArrayList strList = new ArrayList<String>(Arrays.asList("good", "morning"));
        Iterator iter = strList.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        strList.add("afternoon");
        strList.set(2, "midnight");
        System.out.println(strList.indexOf("good"));
        System.out.println(strList.contains("good"));
        System.out.println(strList);//ArrayList 可以直接打印
        strList.remove(1);// remove() @Overload, accept "index" or "element"
        strList.remove("midnight");
        System.out.println(strList);//ArrayList 可以直接打印


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
