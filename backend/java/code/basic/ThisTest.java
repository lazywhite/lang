/*
 * Human.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

abstract class Human {
    String name;
    int age;
    public Human(String name, int age){
        this.name = name; // 1. this引用成员变量
        this.age = age;
    }
    public abstract void work();
}

interface HR{
    void hire();
}


// 1. 抽象类可以调用接口， 但不实现任何方法
abstract class Worker extends Human implements HR{

// 2. 抽象类可以继承抽象类，不实现任何抽象方法， 但必须调用父类构造方法 
    public Worker(String name, int age){
        super(name, age);
    }
}

// 3. 抽象类可以继承实体类， 必须调用父类构造方法
abstract class Tech extends Employee{
    public Tech(String name, int age){
        super(name, age);
    }
}

class Coder extends Employee{
    public Coder(String name, int age){
        super(name, age);
    }

    @Override
    public void work(){
        System.out.println("coder is working");
    }

}

class Employee extends Human implements HR{
    String companyName;
    String companyAddr;

    public Employee(String name, int age){
        super(name, age);
    }

    public Employee(String name, int age, String companyName, String companyAddr){
//        super(name, age);
        this(name, age);  //2. this引用自身构造方法
        this.companyName = companyName;
        this.companyAddr = companyAddr;
    }

    @Override 
    public void work(){
        System.out.println(this.name + " is working...");
    }

    public void doHire(){
        this.hire();
    }

    @Override 
    public void hire(){
        System.out.println(this.name + " is hireing");
    }

    @Override 
    public String toString(){
        String info = "name: " + name + " age: " + age + " company: " + companyName + " company address: "  + companyAddr;

        return  info;
    }

    public void intro(){
        System.out.println(this);//4. this代表自身类对象
    }
}


public class ThisTest{
    public static void main(String[] args){
        Employee e = new Employee("bob", 100, "Atech", "BJ");
        e.work();

        Employee ep = new Coder("harry", 30);
        ep.work();
        if(ep instanceof Coder){
            Coder c = (Coder) ep; 
            c.work();
        }

        HR hr = new Employee("mary", 10, "Btech", "BJ");//基于接口的多态
        hr.hire();//调用实现类的重写方法
        //hr.work();  无法调用
        Human h = new Employee("Lucy", 50, "Ctest", "SH"); //基于超类的多态, 向上转型
        h.work();//调用子类的重写方法


    }
}

