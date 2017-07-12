package basic;
import java.util.*;

/**
 * Created by white on 17/5/18.
 * HashTable是线程安全的, HashMap是非线程安全的
 * concurrentHashMap是HashTable的替代
 */
public class MapTest {
    public static void main(String[] args){
        Student st1 = new Student(100, "bob", 10);
        Student st2 = new Student(110, "lucy", 40);
        Map stuMap = new HashMap();
        stuMap.put("bob", st1); //put 添加k-v
        stuMap.put("lucy", st2);

        //stuMap.clear();//清空
        System.out.println(stuMap.containsKey("bob")); //成员检测
        System.out.println(stuMap.containsValue(st1));
        System.out.println(stuMap.get("lucy")); //get() 由key获取v
        System.out.println(stuMap.size());//
        stuMap.remove("lucy");
        System.out.println(stuMap.size());
        System.out.println(stuMap.isEmpty());

        //entrySet()效率比keySet()效率高
        Iterator iter = stuMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            System.out.println( entry.getKey());
            System.out.println( entry.getValue());
        }
    }
}
