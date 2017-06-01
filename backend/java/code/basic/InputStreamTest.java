import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * Created by white on 17/5/20.
 * java.io 两大基类 InputStream/OutputStream(面向字节) Reader/Writer(面向字符)
 * InputStream是面向字节的流，因此每次操作都是针对于一个字节，因此就无法对中文进行处理
 */
public class InputStreamTest {
    public static void main(String[] args) throws IOException, FileNotFoundException{
        FileInputStream fi = new FileInputStream("/Users/white/todo");
        int b;
        while((b=fi.read()) != -1){
            System.out.print((char)b);
//            System.out.print(Integer.toHexString(b));
        }
        fi.close();

    }
}
