import java.io.File;
import java.io.IOException;
/**
 * Created by white on 17/5/20.
 */
public class FileTest {
    public static void main(String[] args) throws IOException{
        File dir = new File(".");
        System.out.println(dir.getCanonicalPath());
        File test = new File("test");
        if(!test.exists()){
            test.mkdir();
        }
        File fl = new File(test, "fl.txt");
        if(!fl.exists()){
            fl.createNewFile();
        }
        System.out.println(fl.getCanonicalPath());

        int i = (int)(fl.length()/1024 + 1); //f.length() 返回字节数
        System.out.println(i);
        fl.delete();
        test.delete();

        File oo = new File("oo");
        for(String s : oo.list()){
            System.out.println(s);
        }
        System.out.println(oo.getPath());
        System.out.println(oo.getAbsolutePath());
        System.out.println(oo.isDirectory());
//        oo.mkdirs(); // mkdir -p
        for(File f : oo.listFiles()) {
            System.out.println(f.getName());
        }
//        oo.setReadable(true);
//        oo.setWritable(true);
        System.out.println(oo.lastModified());
    }
}
