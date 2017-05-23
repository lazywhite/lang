
/**
 * Created by white on 17/5/23.
 */
public class NumberTest {
    public static void main(String[] args) {
        int i = 100;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toOctalString(i));
        System.out.println(Integer.toHexString(i));
        System.out.println(Integer.toString(i));

        System.out.println(Integer.valueOf("1111", 2));
        System.out.println(Integer.valueOf("125", 8));
        System.out.println(Integer.valueOf("ABC", 16));

        int j = 011; //0开头表示8进制
        int k = 0b111;//0b开头表示二进制
        int z = 0x11;//0x开头表示12进制
        System.out.println(j);
        System.out.println(k);
        System.out.println(z);

    }
}
