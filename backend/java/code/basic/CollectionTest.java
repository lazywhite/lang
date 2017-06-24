package basic;
import java.util.*;

/**
 * Created by white on 17/5/26.
 * Collection是一个接口, set, list均调用, map不调用
 * Collections是一个工具类， 提供对List对象的操作
 */
public class CollectionTest {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 9};
        System.out.println(Arrays.toString(arr));
//        Collections.shuffle(arr);//只接受List<?>
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 8, 4));
        for(Integer i: list){
            System.out.print(i + " ");
        }
        Collections.shuffle(list);//打乱
        System.out.println();
        for(Integer i: list){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));
        Collections.reverse(list);//反转列表顺序
        for(Integer i: list){
            System.out.print(i + " ");
        }
    }
}
