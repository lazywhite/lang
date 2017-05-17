//package tool;
import java.util.Date;

public class ReflectTest{
    public static void main(String[] args) throws InstantiationException,IllegalAccessException{
        Class dc = Date.class;
        Object ob = dc.newInstance();
        Date d = (Date)ob;
        System.out.println(d);
    
    }
}
