import java.util.Arrays;
/*
 * java数据类型分为
 *      基本数据类型
 *      引用数据类型
 *
 *java基础数据类型都不是面向对象的， 所以采用包装类
 *       Byte
 *       Short
 *      Integer
 *      Long
 *      Boolean
 *      Character
 *      Float
 *      Double
 *
 * 包装类与基本类型的转换
 */

public class DataType{
    public static void main(String[] args){
        /*
         *byte类型, 1字节
         */
        System.out.println("----byte-----");
        byte b = 10;
        String s = "hello";
        Byte x = new Byte(b); //Byte类接受两种参数 byte 和string
        //Byte y = new Byte(s);
        System.out.println(x);
        //System.out.println(y);



        /*
         *short类型, 2字节， 
         */
        System.out.println("----short-----");
        short st = 100;
        Short stt = new Short(st);
        System.out.println(stt.shortValue());

        /*
         *int类型, 4字节
         */
        //进制转换
        System.out.println("------int------");
        int i = 100;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toOctalString(i));
        System.out.println(Integer.toHexString(i));
        System.out.println(Integer.toString(i));

        System.out.println(Integer.valueOf("1111", 2));
        System.out.println(Integer.valueOf("125", 8));
        System.out.println(Integer.valueOf("ABC", 16));

        i = 0b11; //0b开头表示二进制
        System.out.println(i);
        i = 011; //0开头表示8进制
        System.out.println(i);
        i = 0xff;//0x开头表示十六进制
        System.out.println(i);


        Integer ii = new Integer(i);
        System.out.println(ii);

        System.out.println(ii.intValue());

        /* Long 类型, 8字节
         *
         */
        System.out.println("------long------");
        long tm = System.currentTimeMillis(); //从1970至今的毫秒数
        System.out.println(tm);
        tm  = tm / 1000/ 3600/ 24 /365;
        System.out.println(tm);

        tm = 1000L;
        System.out.println(tm);

        long l1 = Long.MAX_VALUE;
        long l2 = Long.MAX_VALUE - 10;
        System.out.println(l1);
        System.out.println(l2);


        /*
         * Boolean 类型, 不占字节
         *
         */
        System.out.println("------boolean------");
        boolean bt = false;

        /*
         *char类型, 2字节
         */
        System.out.println("------char------");
        char[] cs = new char[10];
        s.getChars(0, s.length(), cs, 0); //getChars(srcStart, srcEnd, destArray, destStart) 不包括srcEnd
        System.out.println(Arrays.toString(cs));

        byte[] bs = s.getBytes();//byte存储数字, 
        System.out.println(Arrays.toString(bs));


        char c1 = 'a';//必须用单引号赋值
        System.out.println(c1);
        System.out.println((byte)c1);
        c1 = 65;//可以用整数赋值, 对应ASCII编码
        System.out.println(c1);

        /*
         * Float类型， 4字节
         */
        System.out.println("------float------");
        int a1 = 0x7fffffff;
        int a2 = 0x7ffffff0;
        System.out.println(a1);
        System.out.println(a2);
        float f1 = a1;
        float f2 = a2;
        System.out.println(f2 == f1);//类型转换失败

        /*
         * Double类型， 8字节
         */
        System.out.println("------double------");
        double d1 = l1;
        double d2 = l2;
        double d3 = a1;
        double d4 = a2;
        System.out.println(d2 == d1);//类型转换失败
        System.out.println(d3 == d4);//类型转换成功

        System.out.println(6<<2);//左移, 变大
        System.out.println(6>>2);//右移, 变小
        System.out.println(4|2);//按位或
        System.out.println(4&2);//按位与
        System.out.println(4^2);//按位异或
        System.out.println(~5);//按位取反 --> -6 // 负数减一
        System.out.println(~100);//按位取反 --> -101
    }

}
