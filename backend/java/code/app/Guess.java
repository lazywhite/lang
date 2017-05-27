import java.util.Scanner;
import java.util.Random;
public class Guess{
    public static void main(String[] args){ 
        guess();
    }
    public static void guess(){
        int total=0;
        int num;
        Random r = new Random();
        int pivot  = r.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        do{
            total++;
            System.out.println("please input your number between 1 and 100");
            num = sc.nextInt(); 
            if (num == pivot){
                System.out.println("You are right, num is: " + pivot);
                System.out.println("total num: " + total);
                break;
            }
            if(num > pivot){
                System.out.println("too big");
            }else{
                System.out.println("too small");
            }

        }while(true);
    }
}
