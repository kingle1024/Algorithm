package BookStudy.week2_day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOK_11286_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                priorityQueue.add(new int[]{Math.abs(num), num});
            }else{
                if(priorityQueue.isEmpty()){
//                    System.out.println("0");
                    sb.append("0\n");
                }else {
                    int[] r = priorityQueue.poll();
//                    System.out.println(r[1]);
                    sb.append(r[1]+"\n");
                }
            }
        }
        System.out.println(sb);


    }

}
