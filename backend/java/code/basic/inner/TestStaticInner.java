/**
 * Created by white on 17/5/20.
 * 静态内部类
 */

class StaticOuter {
    public static int x = 3;
    public int y = 30;
    static class Inner{
        static int x = 4;
        void innerFunc(){
            int x = 5;
            System.out.println("local x is " + x);
            System.out.println("inner x is " + this.x);
            System.out.println("outer static x is " + StaticOuter.x);
//            System.out.println("outer y is " + y);
        }

    }
}

public class TestStaticInner {
    public static void main(String[] args) {
        StaticOuter.Inner in = new StaticOuter.Inner();
//        System.out.println(StaticOuter.Inner.x);
        in.innerFunc();
    }
}
