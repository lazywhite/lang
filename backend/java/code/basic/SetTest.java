package basic;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by white on 17/5/18.
 */
public class SetTest {
    public static void main(String[] args){
        Student st1 = new Student(1, "bob", 10);
        Student st2 = new Student(2, "lucy", 30);
        Set<Object> sset = new HashSet();
        sset.add(st1);//添加元素
        sset.add(st2);
        sset.add(st2);//集合元素不重复
        System.out.println(sset.size());
        System.out.println(sset.contains(st2));
        sset.remove(st2); //删除元素
        for(Object s: sset){
            Student st = (Student) s;
            System.out.println(st.getName());
        }
        //sset.clear(); //清空
    }
}
