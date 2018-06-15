package basic;
import java.util.Collections;
import java.util.LinkedList;
/**
 * Created by white on 17/5/19.
 * LinkedList 可以被当做堆栈, 队列, 或双端队列进行操作
 * 每个元素除了存储自己的数据, 还包含前一个与后一个元素的引用
 *
 * getFirst() 使用前需要检查isEmpty(), 不然会报错, peekFirst()不需要
 *
 * 按index操作
 *      remove()
 *      get()
 *      pop()
 *  addAll(): 接受List
 *  
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Student st1 = new Student(10, "bob", 34);
        Student st2 = new Student(11, "lucy", 24);
        Student st3 = new Student(12, "nancy", 56);
        Student st4 = new Student(14, "jerry", 36);
        Student st5 = new Student(15, "yank", 36);
        ll.add(st1);
        ll.add(st2);
        ll.add(st3);
        System.out.println(ll.toString());
//        ll.remove(st3); // 只能按照index删除
        System.out.println(ll.isEmpty());
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
//        System.out.println(ll.removeFirst());
//        System.out.println(ll.removeLast());
        ll.addLast(st4);
        ll.addFirst(st5);
//        ll.removeFirst();
//        ll.removeLast();
        System.out.println(ll.element());
//        System.out.println(ll.pop());
        System.out.println(ll.size());
        System.out.println(ll);
        System.out.println("peek first element: " + ll.peekFirst());//retrive but not remove the first element
        System.out.println("peek last element: " + ll.peekLast());//retrive but not remove the last element

        System.out.println(ll.toString());
        System.out.println(ll.get(0));//get by index
        System.out.println(Collections.max(ll)); //get max  element
        System.out.println(Collections.min(ll)); //get min element

    }
}
