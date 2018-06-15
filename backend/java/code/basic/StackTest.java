package basic;
import java.util.Stack;
/**
 * Created by white on 17/5/26.
 * stack: 栈, 后进先出
 */
public class StackTest {
    public static void main(String[] args) {
        Stack st = new Stack<Integer>();
        st.push(100);
        st.push(200);
        st.pop();
        if(!st.empty()) {
            System.out.println(st.peek());//查看栈顶部的对象
            System.out.println(st.capacity());
        }
    }
}
