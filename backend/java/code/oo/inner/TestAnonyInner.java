/**
 * Created by white on 17/5/20.
 * 匿名内部类
 *  在使用次数很少的情况下, 创建一个类太麻烦
 *  适用情况: 继承一个抽象类或者调用一个接口, 然后写上方法的实现
 */
abstract class Person{
    public abstract void eat();
}

class AnonyOuter{
    static int x = 10;
    int y = 20;
    public void eat(){
        Person p = new Person(){
            public void eat(){
                System.out.println("eating something");
            }
        };
        p.eat();

    }
}
public class TestAnonyInner {
    public static void main(String[] args) {
        AnonyOuter ao = new AnonyOuter();
        ao.eat();
    }
}
