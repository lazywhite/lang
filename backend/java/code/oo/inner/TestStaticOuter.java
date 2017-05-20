package oo.inner;

/**
 * Created by white on 17/5/20.
 * 匿名内部类
 */
public class TestStaticOuter {
    public static void main(String[] args) {
        StaticOuter outer = new StaticOuter();
        outer.outerFunc();
        StaticOuter.Inner in = new StaticOuter.Inner();
        in.innerFunc();
    }
}
