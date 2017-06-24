package app;
import java.util.Scanner;
public class ScoreEval{
    public static void main(String[] args){
        System.out.println("Please input your scores");
        int[] scores = new int[5];
        Scanner sc = new Scanner(System.in); 
        for(int i=0;i<scores.length;i++){
            int s = sc.nextInt();
            if(s<0||s>100){
                System.out.println("unlegal score");
                break;
            }
            scores[i] = s;
        }
        //平均成绩
        //总成绩
        //最高
        //最低
        int total=0, min=1000, max=0;
        double avg;
        for(int s:scores){
            total += s;
            if(s<min){
                min = s;
            }
            if(s > max){
                max = s;
            }
        }
        avg = (double)total/5;
        System.out.println("总成绩: " + total);
        System.out.println("平均成绩: " + avg);
        System.out.println("最高成绩: " + max);
        System.out.println("最低成绩: " + min);
    }
}
