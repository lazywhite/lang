package basic;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * Created by white on 17/5/20.
 * FileReader 接收char[], InputStream 接收byte[]
 * InputStreamReader OutputStreamWriter可以指定编码方式
 *
 */
public class FileReaderTest {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            FileReader fr = new FileReader("/Users/white/todo");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            br.close();
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
