package Baekjoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOK_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            final int num = Integer.parseInt(st.nextToken());
            if (!pq.contains(num)) {
                pq.add(num);
            }
        }

        while (!pq.isEmpty()) {
            bw.write(pq.poll() + " ");
        }

        bw.flush();
        bw.close();
    }
}
