package oo.inner;

/**
 * Created by white on 17/5/18.
 */
public class Outer {
    private static int x = 3;
    static class Inner{
        static int x = 4;
        static void func(){
            System.out.println(x);
        }
    }
    public void method(){
        Inner in = new Inner();
        in.func();
        System.out.println(x);
    }
}
