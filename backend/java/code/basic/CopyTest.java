import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by white on 17/5/20.
 */
public class CopyTest {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            copy("/Users/white/todo", "/Users/white/todo.bak");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void copy(String src, String dst) throws FileNotFoundException, IOException{
        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dst);

            byte[]  buffer = new byte[1024];
            int len = 0;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
            fis.close();
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
