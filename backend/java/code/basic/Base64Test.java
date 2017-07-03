package basic;
import java.io.IOException;
import java.util.Base64;
/**
 * Created by white on 17/5/20.
 */
public class Base64Test {
    public static void main(String[] args) throws IOException{
        String str = "中文";
        String encoded = Base64.getEncoder().encodeToString(str.getBytes());
        byte[] asBytes = Base64.getDecoder().decode(encoded);
        System.out.println(new String(asBytes, "utf-8"));
        String urlEncoded = Base64.getUrlEncoder().encodeToString("/path/user?arg1=10&arg2=&arg1=11".getBytes());
        byte[] urlOut = Base64.getUrlDecoder().decode(urlEncoded);
        System.out.println(new String(urlOut, "utf-8"));

    }
}
