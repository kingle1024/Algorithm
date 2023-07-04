package leetCode;

import java.util.PriorityQueue;

public class p2706 {
    public static void main(String[] args) {

        int[] arr = {1,2,2};

        System.out.println("arr = " + buyChoco(arr, 3));
    }
    public static int buyChoco(int[] prices, int money) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : prices){
            priorityQueue.add(num);
        }
        int temp = 0;
        temp += priorityQueue.poll();
        temp += priorityQueue.poll();

        return  temp > money ? money : money-temp;
    }
}
