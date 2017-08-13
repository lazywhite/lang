package basic;
import java.util.TreeMap;
import java.util.Map;

/**
 * Created by white on 17/5/19.
 * TreeMap 实现红黑树算法的自排序Map, 查询速度高
 * 红黑树更是一颗自平衡的排序二叉树。
 * TODO: entrySet()遍历
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Student st1 = new Student(10, "bob", 34);
        Student st2 = new Student(11, "lucy", 24);
        Student st3 = new Student(12, "nancy", 56);
        Student st4 = new Student(14, "jerry", 36);
        Student st5 = new Student(15, "yank", 36);
        TreeMap tm = new TreeMap<String, Object>();
        tm.put("bob", st1);
        tm.put("nancy", st3);
        tm.put("yank", st5);
        tm.put("lucy", st2);
        tm.put("jerry", st4);
        System.out.println(tm.size());
        Map.Entry<String, Student> enSmallest = tm.firstEntry(); //return smallest entry
//        System.out.println(tm.firstEntry());
        System.out.println(enSmallest);
        Map.Entry<String, Student> enLargest = tm.lastEntry(); //return largest entry
        System.out.println(enLargest);
        System.out.println(tm.ceilingKey("dd"));//return least key greater than or equal to given key
        System.out.println(tm.floorKey("dd"));//return greatest key less than or equal to given key
//        tm.pollFirstEntry(); //remove and return the smallest element
//        tm.pollLastEntry();//remove and return the largest element
//        tm.clone();//shadow copy
//          tm.descendingMap()//倒序view
    }
}
