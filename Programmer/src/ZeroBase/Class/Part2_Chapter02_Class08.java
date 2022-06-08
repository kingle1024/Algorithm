package ZeroBase.Class;

import java.util.Queue;
import java.util.LinkedList;
public class Part2_Chapter02_Class08 {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.contains(3)); // true
        System.out.println(queue.size()); // 3
        System.out.println(queue.isEmpty()); // false

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.poll()); // null


    }
}
