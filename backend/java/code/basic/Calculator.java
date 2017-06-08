/*
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 *
 * 1. 通过if else进行异常处理， 代码臃肿
 * 2. 很难穷举所有异常状况， 程序不健壮
 *
 * 3. 用try catch语句来捕获所有类型异常
 */
import java.util.Scanner;
import java.util.InputMismatchException;
public class Calculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = 0, num2 = 0;
        while(true){
            try{
                System.out.println("Please input an Integer");
                num = sc.nextInt();
                System.out.println("Please input an divider");
                num2 = sc.nextInt();

                String str = String.format("%d/%d=%d", num, num2, num/num2);
                System.out.println("result: " + str);

            }catch(ArithmeticException e){
                System.out.println("divider can't be zero");
                System.exit(10);
            }catch(InputMismatchException e){
                System.out.println("Only accept Integer");
                System.exit(10);
            }

            System.out.println("Continue?");
            String r = sc.next();
            if(!r.equalsIgnoreCase("y")){
                break;
            }
        }

    }
}

