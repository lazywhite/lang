class MemberOuter{
    static int x = 3;
    int y = 5;
    //成员内部类
    class Inner{
//        static int x = 4;
        int x = 4;
        int y = 5;
        void innerFunc(){
            int x = 10;
            System.out.println("inner local x: " + x);
            System.out.println("inner member x: " + this.x);
            System.out.println("outer  x: " + MemberOuter.this.y);//访问外部类非静态成员
            System.out.println("outer  x: " + MemberOuter.x);//访问外部类静态成员
        }
    }

    public void accessInner(){
        Inner in = new Inner();
        in.innerFunc();
        int x = 5;
        System.out.println("outer local x is: " + x);
//        System.out.println("inner member x is: " + Inner.x);
        System.out.println("inner member y is: " + in.y);
        System.out.println("outer member x is: " + this.x);
    }
}


public class TestMemberInner {
    public static void main(String[] args){
        MemberOuter outer = new MemberOuter();
        outer.accessInner();
    }
}
