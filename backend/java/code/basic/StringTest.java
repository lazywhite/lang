/**
 * String 类型为immutable, thread safe
 * StringBuilder类型是可变的， 在字符串拼接，修改时效率比较高；但不是线程安全的
 * StringBuffer类型跟StringBuilder特性基本相同， 但是thread safe的
 */
public class StringTest{
    public static void main(String[] args){
        String st = "test01";
        StringBuilder strBuilder = new StringBuilder();
        for(int i=0;i<=100;i++){
            strBuilder.append(i);
        }
        System.out.println(strBuilder);
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("test string");
        strBuffer.append("test string");
        System.out.println(strBuffer);
    }
}
