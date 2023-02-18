package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class BOK_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int zeroCnt = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < loop; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                zeroCnt++;
                if(priorityQueue.isEmpty()){
                    result.add(0);
                }else{
                    result.add(priorityQueue.poll());
                }
            }else {
                priorityQueue.add(num);
            }
        }


        for (int i = 0; i < zeroCnt; i++) {
            bw.write(result.get(i).toString());
            bw.write("\n");
        }

        bw.flush();

    }
}
