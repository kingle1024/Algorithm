package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOK_11866 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!queue.isEmpty()){
            idx++;
            if(idx == h){
                sb.append(queue.poll());
                if(queue.size() != 0) {
                    sb.append(", ");
                }
                idx = 0;
            }else{
                queue.add(queue.poll());
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
