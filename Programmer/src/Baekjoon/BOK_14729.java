package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOK_14729 {

    // 14729
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            double d = Double.parseDouble(br.readLine());
            if(pq.size() < 7) {
                pq.add(d);
            } else if(d <= pq.peek()) {
                pq.poll();
                pq.add(d);
            }
        }

        for(int i = 1; i <= 7; i++) {
            bw.write(String.format("%.3f", pq.poll()) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
