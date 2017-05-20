package oo.inner;

/**
 * Created by white on 17/5/20.
 * 静态内部类
 */

public class StaticOuter {
    public static int x = 3;
    static class Inner{
        int x = 4;
        void innerFunc(){
            int x = 5;
            System.out.println("local x is " + x);
            System.out.println("inner x is " + this.x);
        }

    }
    void outerFunc(){
        System.out.println("outer x is " + x);
    }
}
