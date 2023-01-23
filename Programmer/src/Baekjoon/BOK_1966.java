package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOK_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());


        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < loop; i++) {
            Queue<Print> queue = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            insertQueue(queue, st, N, M);
            int cnt = 0;

            while (!queue.isEmpty()) {
                Print print = queue.poll();
                boolean isOver = false;

                for (Print next : queue) {
                    if (print.num < next.num) {
                        isOver = true;
                        queue.add(print);
                        break;
                    }
                }

                if (!isOver) {
                    cnt++;
                    if (print.idx == M) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.println(sb);


    }

    private static void insertQueue(Queue<Print> queue, StringTokenizer st, int N, int M) {
        for (int j = 0; j < N; j++) {
            int queueNum = Integer.parseInt(st.nextToken());
            if(j == M) {
                queue.add(new Print(true, queueNum, j));
            }else{
                queue.add(new Print(false, queueNum, j));
            }
        }
    }

    static class Print{
        boolean is;
        int num;
        int idx;

        public Print(boolean is, int num, int idx) {
            this.is = is;
            this.num = num;
            this.idx = idx;
        }
    }
}
