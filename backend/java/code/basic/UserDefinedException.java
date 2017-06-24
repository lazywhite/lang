package basic;
import java.util.Scanner;
class MyException extends Exception{
    String str;
    MyException(String st) {
        str=st;
    }
    public String toString(){
        return ("Invalid Marks entered! "+ str) ;
    }
}

public class UserDefinedException{
    public static void main(String args[]){
        try{
            Scanner input=new Scanner(System.in);
            System.out.print("Enter marks: ");
            int marks=input.nextInt();
            if(marks < 15){
                throw new MyException("Error! Marks are less than 15.");
            }
        }
        catch(MyException e){
            System.out.println(e) ;
        }
    }
}
