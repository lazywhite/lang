package basic;
public class SwitchTest{

/*
    没有break的case, 会fallthrough
    仅适用于byte, short, char, int, String, enum 
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
        int m = 3;
        switch(m) {
            case 1:
            case 2:
            case 3:
                System.out.println("不及格");
                break;
            case 4:
            case 5:
                System.out.println("及格");
                break;
            default:
                System.out.printf("不合法");
        }

    }

}
