/*
 * java 参数的传递全部为传值调用(call by value)
 *
 * 基本数据类型， 传递变量的一个copy
 * 引用数据类型， 传递变量指针的一个copy
 *
 * 效果
 *      一个方法不能修改一个基本数据类型的参数
 *      一个方法可以改变一个对象参数的状态
 *      一个方法不能让对象参数引用一个新的对象
 */
import java.util.*;

class Card{
    public String color;
    public Card(String color){
        this.color = color;
    }
    @Override
    public String toString(){
        return "Card: " + this.color;
    }

}
public class PassParam {
    public static void main(String[] args){
        Card c = new Card("red");
        change01(c);
        System.out.println(c);

        change02(c);
        System.out.println(c);

        int[] m = {10, 20, 30};
        changeA1(m);
        System.out.println(Arrays.toString(m));

        String s = "hello";
        changes1(s);
        System.out.println(s);

        int a = 20;
        changei1(a);
        System.out.println(a);
            

    }
    public static void changei1(int  i){
        i = 10;
    }
    public static void changes1(String  s){
        s = "good";
    }
    public static void changeA1(int[]  arr){
        arr[1] = 50;
    }

    public static void change01(Card c){
        c.color = "blue";
    }
    public static void change02(Card c){
        c = new Card("yello");
    }
}

