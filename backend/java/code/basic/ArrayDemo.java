package basic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;
import java.util.Iterator;


public class ArrayDemo {
	public static void main(String[] args){
		int[] arr = new int[10]; //声明固定长度的数组
		for(int i=0;i<arr.length;i++){
			Random r = new Random();
			arr[i] = r.nextInt(100);
			
		}
		System.out.println(arr[-1]); //negative index is supported
		
		System.out.print(Arrays.toString(arr));
	
		int[] arr1;
		arr1 = new int[]{1, 2, 3}; //先声明， 后赋值
		
		String[] arr2 = {"hello", "world"};
		System.out.println(Arrays.toString(arr2));
		
		HashMap<String, Object> hm1 = new HashMap<String, Object>();
		hm1.put("name", "bob");

		System.out.println(hm1.get("name"));
		
	
	}
}
