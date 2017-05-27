/*
 * 输入一个数字， 检查是否是素数
 */
import java.util.Scanner;
import java.util.Random;
public class Prime{
    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in);
        do{
            int num = sc.nextInt(); 
            if(testPrime(num)){
                System.out.println("It's a prime");
            }else{
                System.out.println("Not a prime");
            }
        }while(true);
    }
    public static boolean testPrime(int num){
        for(int i=2;i<num;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
