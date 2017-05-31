/*
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
import java.util.Scanner;

public class Score {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("请输入成绩");
            int a = sc.nextInt();
            String str;
            switch(a/10){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    str = "不及格"; 
                    break; 
                case 6:
                case 7:
                    str = "及格";
                    break;
                case 8:
                case 9:
                case 10:
                    str = "优秀";
                    break;
                default:
                    str = "不合法的成绩";
                    break;
            }
            System.out.println(str);
            System.out.println("想继续吗?");
            String s = sc.next();
            if(s.equalsIgnoreCase("Y")){
                continue;
            }else{
                break;
            }
        }
    }
}

