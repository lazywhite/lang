package basic;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by white on 17/5/18.
 * TODO: named group
 */
public class RegExTest {
    public static void main(String[]args){
        String testStr = "24234234@qq.com";
        String reg = "[\\d]*"; // back slash must be escaped
        String allPattern = ".*";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(testStr);
        while(m.find()){
            System.out.print(m.group());
        }

        System.out.println(testStr.matches(reg)); //matches() 全部匹配才会返回true
        System.out.println(testStr.matches(allPattern));



    }
}
