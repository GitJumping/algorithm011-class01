package Week_01;

import java.util.Stack;

public class StackImplDemo {
    /**
     * http://developer.classpath.org/doc/java/util/Stack-source.html
     * Stack extends Vector
     * push(), pop(), peek(), empty(), search(), five methods defined for itself
     * several methods inherited from Vector
     * add, add, addAll, addAll, addElement, capacity
     * or Object
     * finalize, getClass, notify
     * or Collection
     * parallelStream, stream
     * @param args
     */
    public static void main(String[] args) {
        //FILO
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        //[1, 2, 3, 4]
        System.out.println(stack);
        //search given element, return index of this ele in stack
        System.out.println("->"+stack.search(4));

        //remove top ele
        stack.pop();
        stack.pop();
        //return the top ele of this stack
        Integer topEle = stack.peek();
        //2
        System.out.println(topEle);
        System.out.println(" index of 3 is "+stack.search(3));


    }
}
