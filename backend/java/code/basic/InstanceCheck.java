package basic;
class A {
}

class B extends A {
}

public class InstanceCheck{
  public static void main(String[] args) {

    A a = new A();
    B b = new B();
    A ba = new B();
    System.out.println("1------------");
    System.out.println(b instanceof B); //true
    System.out.println(b instanceof A);//true
    System.out.println(b instanceof Object);//true
    System.out.println(null instanceof Object);//false
    System.out.println("2------------");
    System.out.println(b.getClass().isInstance(b));//true;
    System.out.println(b.getClass().isInstance(a));//false
    System.out.println("3------------");
    System.out.println(a.getClass().isInstance(ba));//true
    System.out.println(b.getClass().isInstance(ba));//true
    System.out.println(b.getClass().isInstance(null));//false;
    System.out.println("4------------");
    System.out.println(A.class.isInstance(a));//true
    System.out.println(A.class.isInstance(b));//true
    System.out.println(A.class.isInstance(ba));//true
    System.out.println("5------------");
    System.out.println(B.class.isInstance(a));//false
    System.out.println(B.class.isInstance(b));//true
    System.out.println(B.class.isInstance(ba));//true
    System.out.println("6------------");
    System.out.println(Object.class.isInstance(b));//true
    System.out.println(Object.class.isInstance(null));//false
  }
}
