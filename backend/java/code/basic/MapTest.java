import java.util.HashMap;
import java.util.Map;

/**
 * Created by white on 17/5/18.
 */
public class MapTest {
    public static void main(String[] args){
        Student st1 = new Student(100, "bob", 10);
        Student st2 = new Student(110, "lucy", 40);
        Map stuMap = new HashMap();
        stuMap.put("bob", st1); //put 添加k-v
        stuMap.put("lucy", st2);

        for(Object key: stuMap.keySet()){
            System.out.println(stuMap.get(key));
        }

        //stuMap.clear();//清空
        System.out.println(stuMap.containsKey("bob")); //成员检测
        System.out.println(stuMap.containsValue(st1));
        System.out.println(stuMap.get("lucy")); //get() 由key获取v
        System.out.println(stuMap.size());//
        stuMap.remove("lucy");
        System.out.println(stuMap.size());
        System.out.println(stuMap.isEmpty());
    }
}
