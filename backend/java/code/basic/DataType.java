package basic;
import java.util.Arrays;
/*
 * java数据类型分为
 *      基本数据类型
 *      引用数据类型
 *
 * java保留基础数据类型是因为相对包装类型, 性能比较好
 * 采用包装类是为了能方便调用一些面向对象的方法
 *      Byte
 *      Short
 *      Integer
 *      Long
 *      Boolean
 *      Character
 *      Float
 *      Double
 *
 * 包装类与基本类型的互换
 *      int i = 10
 *      Integer m = new Integer(i)  装箱
 *      m.intValue() 拆箱
 *
 * 基本类型与String类型互换
 *      基本类型转String
     *      int i = 10;
            String str = String.valueOf(i);
 *      String 转基本类型
 *          int m = Integer.parseInt(str);
 *
 *  包装类与String互换
 *      Integer i = 10;
 *      String str = i.toString();
 *
 *      Integer m = Integer.valueOf(str);
 *
 *  自动拆箱装箱
 *      Integer i = 10; // 自动装箱   Integer i = Integer.valueOf(10)
 *      int t = i; 自动拆箱   int t = i.intValue();
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
        byte ccc = x.byteValue();
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
        System.out.println(-6>>2);//有符号右移
        System.out.println(-9>>>2);//无符号右移
        System.out.println(4|2);//按位或
        System.out.println(4&2);//按位与
        System.out.println(4^2);//按位异或
        System.out.println(~5);//按位取反 --> -6 // 负数减一
        System.out.println(~100);//按位取反 --> -101
    }

}
