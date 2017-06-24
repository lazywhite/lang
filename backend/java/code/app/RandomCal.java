package app;

import java.util.Scanner;

public class RandomCal {
	public static void main(String[] args){
		/*
		 * 随机生成10个算术题，让用户输入结果 并计算得分
		 * 输入-1 可退出程序
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
