import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by white on 17/5/20.
 *
 */
public class FileWriterTest {
    public static void main(String[] args) throws IOException{
        try {
            FileWriter fw = new FileWriter("/Users/white/fwtest.txt", true);//true --> append mode
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("line 01");
            bw.newLine();//跨平台换行符
            bw.write("中文");
            bw.flush();

            bw.close();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
