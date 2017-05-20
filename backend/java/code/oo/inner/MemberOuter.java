
/**
 * Created by white on 17/5/18.
 * 成员内部类
 */
public class MemberOuter{
    int x = 3;
    class Inner{
        int x = 4;
        void innerFunc(){
            System.out.println(x);
        }
    }
    public void outerFunc(){
        int x = 5;
        Inner in = new Inner();
        in.innerFunc();
        System.out.println("inner x is: " + in.x);
        System.out.println("local x is: " + x);
        System.out.println("outer x is: " + this.x);
    }
}
