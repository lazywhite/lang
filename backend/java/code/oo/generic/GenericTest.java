package oo.generic;

/**
 * Created by white on 17/5/19.
 * PECS: producer extends consumer super
 *  经常读内容的, 适合上边界extends
 *  经常写内容的, 适合下边界super
 *
 * List<? extends Number> list=new ArrayList<Number>();
 * list.add(4.0);//编译错误
 * list.add(3);//编译错误   //虽然可以是number的任意子类型, 但不能多种共存
 *
 *  所有与泛型有关的异常都在编译时发现
 */
class Food{}
class Fruit extends Food{}
class Apple extends Fruit{}
class Plate<T>{
    private T item;
    public Plate(T t){
        item = t;
    }
    public void setItem(T t){
        this.item = t;
    }
    public  T getItem(){
        return this.item;
    }

}
public class GenericTest {
    public static void main(String[] args) {
        Person<String> p = new Person<String>("bob");
        System.out.println(p.getName());

        Person q = new Person<Integer>(100);
        System.out.println(q.getName());

        Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());
//        plate.setItem(new Apple());  //上边界泛型会使set失效, 不能放入任何东西,  但不会使get失效
//        Apple apple = plate.getItem(); //error
        Fruit apple = plate.getItem(); //取出来的东西只能是fruit或者fruit的父类
        //编译器只知道容器内是Fruit或者它的派生类, 但具体什么类不知道


        Plate<? super Fruit> plate1 = new Plate<Fruit>(new Fruit());
        plate1.setItem(new Fruit());//只能装下边界的派生类
        plate1.setItem(new Apple());//ok
//        plate1.setItem(new Food()); //error
//        Apple apple1 = plate1.getItem(); //error
//        Fruit apple1 = plate1.getItem();//error
        Object apple1 = plate1.getItem();//取出来的东西只能放在Object里面, 元素的类型信息全部丢失
    }
}
