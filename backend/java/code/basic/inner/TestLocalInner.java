package basic.inner;
/**
 * Created by white on 17/5/20.
 * 局部内部类
 */
class PartOuter{
    static int x = 10;
    int y = 20;
    public void run(){
        class Inner{
            int z = 20;
            int w = 30;
//            static int w = 30;  //无法定义
            public void test(){
                System.out.println(x);
                System.out.println(y);
                System.out.println(z);
                System.out.println(w);
            }
        }

        Inner i = new Inner();
        i.test();
    }
}
public class TestLocalInner {
    public static void main(String[] args) {
        PartOuter p = new PartOuter();
        p.run();
    }

}
