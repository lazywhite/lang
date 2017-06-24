package basic;
/*
 * 局部变量必须初始化
 * 类变量和实例变量可以不初始化， 自带默认值
 */
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
    public static char clsChar;

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
        EMP p = new EMP();
        System.out.println(p);
        System.out.println(p.f1);
        System.out.println(p.alive);
        System.out.println(EMP.clsInt);
        System.out.println(EMP.clsDouble);
        System.out.println(EMP.clsString);
        System.out.println(EMP.clsBoolean);
        System.out.println(EMP.clsChar);
    }
}
