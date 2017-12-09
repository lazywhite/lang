package basic;
import java.util.Arrays;

/**
 * String 类型为immutable, thread safe
 * 字符串池
 * StringBuilder类型是可变的， 在字符串拼接，修改时效率比较高；但不是线程安全的
 * StringBuffer类型跟StringBuilder特性基本相同， 但是thread safe的
 */
public class StringTest{
    public static String reverse(String str){
        //递归实现字符串反转
        if(str.length() == 1){
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
    public static void main(String[] args){
        //StringBuilder API
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("a string");
        strBuilder.append("a char");
        strBuilder.setCharAt(3, 'b');
        strBuilder.insert(5, "good");
        strBuilder.insert(8, 'c');
        strBuilder.delete(0, 5);//包括start， 不包括end
        System.out.println(strBuilder);

        //StringBuffer API与StringBuilder相同
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("test string");
        strBuffer.append("test string");
        System.out.println(strBuffer);

        /*
        * difference between equals and ==
         */
        String str = "new string";
        String str1 = new String("new string");
        System.out.println(str == str1); // -->false
        System.out.println(str.equals(str1));// -->true
        System.out.println(str.equalsIgnoreCase(str1));
        System.out.println(str.startsWith("new"));
        str.intern();

        // String methods
        String testStr = "abcd@test.com";
        int index = testStr.indexOf('@'); //获取第一个匹配到的位置
        System.out.println(index);
        String subStr = testStr.substring(0, index); //包含start, 不包含end
        System.out.println(subStr);
        String[] all = testStr.split("@");//accept String RegExp, not Char
        System.out.println(Arrays.toString(all));


        String newStr = testStr.replaceAll("test", "local"); //origin string is not modified
        System.out.println(newStr);
        String concatStr = newStr.concat("concat test");//concat method
        System.out.println(concatStr);

        String template = "my name is %s";
        String s1 = String.format(template, "bob");
        System.out.println(s1);
    }
}
