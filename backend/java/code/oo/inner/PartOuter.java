
/**
 * Created by white on 17/5/20.
 * 局部内部类
 */
public class PartOuter {
    public static void main(String[] args) {
        func();
    }
    public static void func(){
        class Inner{
            int x = 10;
            int getX(){
                return this.x;
            }

        }

        Inner i = new Inner();
        System.out.println(i.getX());

    }
}
