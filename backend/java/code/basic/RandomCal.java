package basic;

import java.util.Scanner;

public class RandomCal {
	public static void main(String[] args){
		/*
		 * �������10�������⣬���û������� ������÷�
		 * ����-1 ���˳�����
		 */
		int x, y, result, input, score = 0;
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++){
			x = (int)(Math.random() * 10);
			y = (int)(Math.random() * 10);
			System.out.printf("Please calculate %d + %d = ", x, y);
			result = x + y;
			input = sc.nextInt();
			if (input == -1){
				break;
			}
			if (input == result){
				score += 10;
				System.out.println("Right");
			}else{
				System.out.println("Wrong");
			}
			
		}
		System.out.printf("Your score is %d", score);
	}

}
