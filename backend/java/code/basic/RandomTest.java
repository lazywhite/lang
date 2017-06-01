import java.util.Arrays;
import java.util.Random;

public class RandomTest{
    public static void main(String[] args){
        System.out.println("------random------");
        Random r = new Random();
        System.out.println(r.nextFloat());
        System.out.println(r.nextDouble());
        System.out.println(r.nextBoolean());
        System.out.println(r.nextInt(100));//包括0, 不包括100
        byte[] bbbb = new byte[10];
        r.nextBytes(bbbb);
        System.out.println(Arrays.toString(bbbb));
    }
}
