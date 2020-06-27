package Week_01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Queue Method	Equivalent Deque Method
 * add(e)	addLast(e)
 * offer(e)	offerLast(e)
 * remove()	removeFirst()
 * poll()	pollFirst()
 * element()	getFirst()
 * peek()	peekFirst()
 *
 * Stack Method	Equivalent Deque Method
 * push(e)	addFirst(e)
 * pop()	removeFirst()
 * peek()	peekFirst()
 */
public class NewDequeImplDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("e");
        //[e, b, a]
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        //[e, b, a]
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);

        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("e");
        //[a, b, e]
        System.out.println(deque);
    }
}
