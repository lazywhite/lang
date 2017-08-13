package basic;
import java.util.TreeSet;
import java.util.Iterator;
/**
 * Created by white on 17/5/19.
 * TreeSet 有序集合
 * TreeSet 只能通过迭代器进行遍历
 * TreeSet是基于TreeMap实现的。TreeSet中的元素支持2种排序方式：自然排序 或者 根据创建TreeSet 时提供的 Comparator 进行排序。这取决于使用的构造方法。
 * TreeSet为基本操作（add、remove 和 contains）提供受保证的 log(n) 时间开销。
 */
public class TreeSetTest {
    public static void main(String[] args) {

        TreeSet ts = new TreeSet();
        ts.add("orange");
        ts.add("apple");
        ts.add("banana");
        ts.add("pinapple");
        ts.add("peach");
        ts.add("chestnut");
        System.out.println(ts.size());
        System.out.println(ts.isEmpty());
        System.out.println(ts.floor("banana")); //小于等于此元素的最大值
        System.out.println(ts.lower("banana")); //小于
        System.out.println("larger than orange: " + ts.higher("orange")); //大于
        System.out.println("larger or equal than orange: " + ts.ceiling("orange")); //大于等于此元素的最小值
        System.out.println(ts.headSet("orange", true)); //all elements less than or equal "orange'
        System.out.println(ts.headSet("orange", false));
        System.out.println(ts.tailSet("orange", true)); //all elements larger than or equal "orange"
        System.out.println(ts.tailSet("orange", false));
        System.out.println(ts.subSet("banana", true, "orange", true));  // "banana" << [elements] << "orange"
        System.out.println(ts.subSet("banana", false, "orange", true));  // "banana" < [elements] << "orange"
        System.out.println(ts.subSet("banana", false, "orange", false));// "banana" < [elements] < "orange"

        ts.remove("orange");
        System.out.println(ts.pollFirst());//删除并返回最小的元素
        System.out.println(ts.pollLast()); //删除并返回最大的元素
//        ts.clear(); //清空集合

        //ts.descendingIterator() //反向iterator
        ///ts.descendingSet() //倒序集合

//        Iterator iter = ts.iterator(); //正向遍历
//        while(iter.hasNext()){
//            System.out.println(iter.next());
//        }
    }
}
