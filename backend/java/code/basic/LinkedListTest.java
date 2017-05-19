
import java.util.LinkedList;
/**
 * Created by white on 17/5/19.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Student st1 = new Student(10, "bob", 34);
        Student st2 = new Student(11, "lucy", 24);
        Student st3 = new Student(12, "nancy", 56);
        Student st4 = new Student(14, "jerry", 36);
        ll.add(st1);
        ll.add(st2);
        ll.add(st3);
        System.out.println(ll.toString());
//        ll.remove(st3);
//        System.out.println(ll.toString());
        System.out.println(ll.isEmpty());
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
//        System.out.println(ll.removeFirst());
//        System.out.println(ll.removeLast());
        System.out.println(ll.toString());
        System.out.println(ll.size());
        ll.addLast(st4);
        System.out.println(ll.size());
        System.out.println(ll.element());
        System.out.println(ll.pop());
        System.out.println(ll.size());
        System.out.println(ll.peek());
        System.out.println(ll.toString());

    }
}
