package Week_01;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImplDemo {
    /**
     * Queue is a interface
     * this demo use it implementation class LinkedList
     * AbstractQueue, ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue
     * add() element() offer() peek() poll() remove()
     * @param args
     */
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");
        //[One, Two, Three]
        System.out.println(queue);

        //poll -> peek top & delete top
        String polledElement = queue.poll();
        //One
        System.out.println(polledElement);
        //[Two, Three]
        System.out.println(queue);

        //peek -> only peek top
        String peekedElement = queue.peek();
        System.out.println(peekedElement);
        //[Two, Three]
        System.out.println(queue);

        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
        System.out.println(queue.size());

        queue.add("a");
        queue.add("b");
        queue.add("e");
        //[a, b, e]
        System.out.println(queue);
    }
}
