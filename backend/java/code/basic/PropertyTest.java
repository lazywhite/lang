package basic;
import  java.util.Properties;
import  java.io.FileInputStream;
import  java.io.IOException;

public final class PropertyTest {
    private static String host;
    private static int port;
    static{
        final String dir = System.getProperty("user.dir");//current work dir
        final String config = dir + "/basic/config.properties";
        Properties prop =  new  Properties();
        try {
            FileInputStream fin = new FileInputStream(config);
            prop.load(fin);
            host = prop.getProperty("jdbc.mysql.host").trim();
            port = Integer.parseInt(prop.getProperty("jdbc.mysql.port").trim());
        }catch  (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) throws IOException{

        System.out.println(host);
        System.out.println(port);
    }
}
