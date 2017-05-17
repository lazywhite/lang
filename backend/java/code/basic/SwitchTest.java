package basic;

public class SwitchTest{

/*
    没有break的case, 会fallthrough
 */
    public static void main(String[] args) {
        int i = 24, j = 32, h = 58;
        switch (j - i) {
            case 7:
                h++;
                System.out.println("case 7");
            case 8:
                h++;
                System.out.println("case 8");
            case 9:
                h += 2;
                System.out.println("case 9");
            case 10:
                h += 3;
                System.out.println("case 10");
            default:
                h /= j;
                System.out.println("case default");
        }
        System.out.println(h);
    }

}
