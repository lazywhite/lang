package basic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by white on 17/5/19.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        Student st1 = new Student(1, "bob", 10);
        Student st2 = new Student(2, "lucy", 20);
//        System.out.println(st1 > st2); //不能用操作符比较

        List stList = new ArrayList<Student>();
        stList.add(st2);
        stList.add(st1);
        System.out.println("Before sorting");
        Iterator iter = stList.iterator();
        while(iter.hasNext()){
            Student st = (Student) iter.next();
            System.out.println(st.getName() + ":" + st.getId());
        }
        Collections.sort(stList);
        System.out.println("After sorting");
        iter = stList.iterator();
        while(iter.hasNext()){
            Student st = (Student) iter.next();
            System.out.println(st.getName() + ":" + st.getId());
        }

        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        al.remove(2); //传入int 2， 按下标删除,  int 2 != Integer(2)
        Integer tt = al.get(2);
        al.remove(tt); //传入Integer, 按照对象删除

    }
}
