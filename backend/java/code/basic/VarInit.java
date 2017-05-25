/*
 * 变量无初始化， 默认值
 * Scanner接口的简单使用
 */
import java.util.Scanner;
class EMP{
    public String name ;
    public int age;
    public float score;
    public double f1;
    public boolean alive;
    public static int clsInt;
    public static double clsDouble;
    public static String clsString;
    public static boolean clsBoolean;

    public EMP(){}
    public EMP(String name, int age, float score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString(){
        return "name: " + this.name + " age: " + this.age + " score: " + this.score;
    }
}
public class VarInit{
    public static void main(String[] args){
        System.out.println("Please input your name");
        Scanner sc = new Scanner(System.in);
        String name = sc.next(); //接受字符串
        System.out.println("your name is: "  + name);

        System.out.println("Please input your age");
        int age = sc.nextInt(); //接受字符串
        System.out.println("your age is: "  + age);
        
        System.out.println("Please input your score");
        float score = sc.nextFloat(); //接受字符串
        System.out.println("your score is: "  + score);

        EMP p = new EMP();
        p.name = name;
        p.age = age;
        p.score = score;
        System.out.println(p);
        System.out.println(p.f1);
        System.out.println(p.alive);
        System.out.println(EMP.clsInt);
        System.out.println(EMP.clsDouble);
        System.out.println(EMP.clsString);
        System.out.println(EMP.clsBoolean);
    }
}
