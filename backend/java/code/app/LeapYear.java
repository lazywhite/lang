package app;
import java.util.Scanner;
/* 闰年计算规则
 * 1. 能被4整除， 不能被100整除
 * 2. 能被400整除
 * 
 */

public class LeapYear {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input year: ");
		int m = sc.nextInt();
		if ((m % 4 ==0 && m % 100 != 0)|| (m % 400 == 0)){
			System.out.println("闰年");
		}else{
			System.out.println("平年");
		}
	}
}
