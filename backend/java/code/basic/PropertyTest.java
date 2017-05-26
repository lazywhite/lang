import  java.util.Properties;
import  java.io.FileInputStream;
import  java.io.IOException;

public final class PropertyTest {
    private static String host;
    private static int port;
    static{
        final String dir = System.getProperty("user.dir");//current work dir
        System.out.println(dir);
        final String config = dir + "/basic/config.properties";
        System.out.println(config);
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
    /**
     * 私有构造方法，不需要创建对象
     */
    private  PropertyTest() {
    }

    public   static  String getHost() {
        return  host;
    }

    public   static  int getPort() {
        return  port;
    }

    public static void main(String args[]) throws IOException{

        System.out.println(getHost());
        System.out.println(getPort());
    }
}
