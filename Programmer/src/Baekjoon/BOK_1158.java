package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOK_1158 {

    // 1158
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int idx = 1;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            Integer pollNum = queue.poll();
            if(idx != 0 && idx % K == 0) {
                list.add(pollNum);
            } else {
                queue.add(pollNum);
            }
            idx++;
        }

        bw.write("<");
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i).toString());
            if(i != list.size() -1) {
                bw.write(", ");
            }
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }

}
