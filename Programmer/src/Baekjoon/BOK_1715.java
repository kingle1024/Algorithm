package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOK_1715 {
    static void solution3() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Long> array = new ArrayList<>();
        for(int i=0; i<N; i++){
            array.add(Long.parseLong(br.readLine()));
        }
        if(array.size() == 1){
            System.out.println("0");
            return;
        }else if(array.size() == 2){
            System.out.println(array.get(0) + array.get(1));
            return;
        }
        Collections.sort(array);

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            queue.add(array.get(i));
        }
        long result = 0;
        while(queue.size() > 1){
            long a = queue.poll();
            long b = queue.poll();
            result += (a+b);
            queue.add((a+b));
        }
        System.out.println(result);
    }
    static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> array = new ArrayList<>();
        for(int i=0; i<N; i++){
            array.add(Integer.parseInt(br.readLine()));
        }
        if(array.size() == 1){
            System.out.println("0");
            return;
        }else if(array.size() == 2){
            System.out.println(array.get(0) + array.get(1));
            return;
        }
        Collections.sort(array);

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            queue.add(array.get(i));
        }
        Queue<Integer> queueTmp = new LinkedList<>();
        long result = 0;
        queueTmp.add(queue.poll());
        while(!queue.isEmpty()){
            int t = queue.poll();
            if(!queue.isEmpty()){
                if(queue.peek() >= queueTmp.peek()){
                    int poll = queueTmp.poll();
//                    System.out.println("[1] "+t+" " + poll);
                    queueTmp.add(t + poll);
                    result += t+poll;
                }else{
                    int tmpPoll = queue.poll();
//                    System.out.println("[2] "+t+" " + tmpPoll);
                    queueTmp.add(t + tmpPoll);
                    result += t+tmpPoll;
                }
            }else{
                int tmpPoll = queueTmp.poll();
//                System.out.println("[3] "+t+" " + tmpPoll);
                queueTmp.add(tmpPoll + t);
                result += tmpPoll + t;
            }
            if(queueTmp.size() > 2){
                queue.add(queueTmp.poll());
            }
        }
        if(queueTmp.size() > 1) {
            while (!queueTmp.isEmpty()) {
                int num = queueTmp.poll();
//                System.out.print(num + " - ");
                result += num;
            }
        }
//        System.out.println();
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception{
        solution();
    }
}
