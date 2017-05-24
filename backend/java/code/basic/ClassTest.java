
/**
 * Created by white on 17/5/23.
 * class 是关键字
 * class定义的类， 被jvm解析后, 会生成一个Class类的对象来表示这个类
 * Class没有public的构造函数， 不能人为调用， 只能由jvm调用
 */
class Shapes{
}
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
                                                    IllegalAccessException{
        //获得一个Class对象, 均为泛型, 得到的是Object类
        //第一种方式
        Class obj = Class.forName("Shapes");
        System.out.println("class of obj: " + obj.getClass());
        //第二种方式
        Shapes s = new Shapes();
        Class obj1 = s.getClass();
        System.out.println("class of obj1: " + obj1.getClass());
//        Class obj2 = s.getSuperclass();
//        System.out.println(obj2);
        //第三种方式
        Class obj3 = Shapes.class;
        System.out.println("class of obj3: " + obj3.getClass());

        Object s1 = obj.newInstance();
        System.out.println(s1.toString());

        //获得Shapes类
        Class<Shapes> obj4 = Shapes.class;
        Shapes s2 = obj4.newInstance();
        System.out.println("class of s2: " + s2.getClass().getName());
    }
}
