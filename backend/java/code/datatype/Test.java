import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class Test{
    public static void main(String[] args){
        Random r = new Random();
        int s = r.nextInt(10);
        System.out.println(s);

        String[] al = {"hello", "world"};
        for(int i=0;i<al.length;i++){
            System.out.println(al[i]);
        }
        
        int a = 10, b;
        b = a++;
        System.out.println(b);
        int m = 3, n = 4;
        float f;
        f = n/m;
        boolean flag = (m++ >= n);
        System.out.println(flag);
        System.out.println(m++);
        System.out.println(m);
        System.out.println(f);

        byte bookSize = 127;
        int temp = bookSize;
        int penSize = 200;
//        bookSize = penSize;
        System.out.println(bookSize);

        Object[] ss = {1, "good", 'c'};
        for(Object ms:ss){
            System.out.println(ms);
        }
        if (true)
            System.out.println("print by true");
        System.out.println("always printed");

        char c = '红';
        System.out.println(c);
        //int mm;
        //System.out.println(mm);  //没有初始化， 报错
        boolean b1 = true;
        long s1s = 100000L;
        System.out.println(s1s); 
//        int c;
//        c = (int)b1;  //boolean cant convert to int
//        System.out.println(c); 
    }
}
