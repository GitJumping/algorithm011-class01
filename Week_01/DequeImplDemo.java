package Week_01;

import java.util.Deque;
import java.util.LinkedList;

public class DequeImplDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("e");
        System.out.println(deque);

        //peek -> select top ele, not delete
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        //pop -> select & delete top ele
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }
}
