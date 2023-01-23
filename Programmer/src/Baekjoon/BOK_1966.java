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

            while(!queue.isEmpty()) {
                Print print = queue.poll();
                boolean isOver = false;

                for (Print next : queue) {
                    if (print.num < next.num) {
                        isOver = true;
                        queue.add(print);
                        break;
                    }
                }

                if(!isOver){
                    cnt++;
                    if(print.idx == M){
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
            }



//            int idx = 0;
//            while (!queue.isEmpty()) {
//
//                Print print = queue.poll();
//                if (now < print.num) {
//                    idx++;
//                    break;
//                }
//
//                if (print.is) break;
//            }
//
//            sb.append(idx).append("\n");
        }
        System.out.println(sb);


//        for (int i = 0; i < loop; i++) {
//            Queue<Print> queue = new ArrayDeque<>();
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int arrLength = Integer.parseInt(st.nextToken());
//            int procedure = Integer.parseInt(st.nextToken());
//
//            st = new StringTokenizer(br.readLine());
//
//            if(arrLength <= 1){
//                sb.append("1").append("\n");
//                continue;
//            }
//
//            // p번째로 출력되는 값 출력 필요
//            for (int j = 0; j < arrLength; j++) {
//                int n = Integer.parseInt(st.nextToken());
//                if(j == procedure){
//                    queue.add(new Print(true, n, j));
//                }else {
//                    queue.add(new Print(false, n, j));
//                }
//                max = Math.max(n, max);
//            }
//
//            Print print = queue.poll();
//            int startNum = print.num;
//
//            int cnt = 0;
//            if (max == startNum) {
//                cnt++;
//                if(print.is){
//                    cnt++;
//                    sb.append(cnt).append("\n");
//                    break;
//                }
//            }else{
//                queue.add(print);
//            }
//
//
//            while (true) {
//                // 하나 꺼내고
//                Print poll = queue.poll();
//                if(poll.is){
//                    cnt++;
//                    sb.append(cnt).append("\n");
//                    break;
//                }
//
//                Print next = queue.poll();
//                queue.add(next);
//
//                // 다 돌면서 자기보다 큰 값이 있는지 확인
//                while(true){
//                    Print recurPoll = queue.peek();
//                    // 다음이 본인이면 끝. 즉 본인이 가장 높음
//                    if(recurPoll.idx == next.idx){
//                        cnt++;
//                        queue.poll();
//                        break;
//                        // 본인보다 높은게 있으면
//                    }else if(recurPoll.num > poll.num){
//                        break;
//                    }
//                }
//            }
//
//
//
//        }
//        System.out.println(sb);
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
