package oo.generic;

/**
 * Created by white on 17/5/19.
 */
public class GenericTest {
    public static void main(String[] args) {
        Person<String> p = new Person<String>("bob");
        System.out.println(p.getName());

//        Person<Integer> q = new Person<Integer>(100);
        Person q = new Person<Integer>(100);
//        Person q = new Person<Integer>("skj");//type error
        System.out.println(q.getName());
    }
}
