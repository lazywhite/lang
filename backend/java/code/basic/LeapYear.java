package basic;
import java.util.Scanner;
/* ����������
 * 1. �ܱ�4������ ���ܱ�100����
 * 2. �ܱ�400����
 * 
 */

public class LeapYear {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input year: ");
		int m = sc.nextInt();
		if ((m % 4 ==0 && m % 100 != 0)|| (m % 400 == 0)){
			System.out.println("����");
		}else{
			System.out.println("ƽ��");
		}
	}
}
