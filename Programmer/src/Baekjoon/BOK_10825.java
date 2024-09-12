package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOK_10825 {

    // 10825
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<People> pq = new PriorityQueue<>((o1, o2) -> {
            // 국어 점수가 감소하는 순서로
            int korea = Integer.compare(o2.value1, o1.value1);
            if(korea != 0) {
                return korea;
            }

            // 국어 점수가 같으면 영어 점수가 증가하는 순서로
            int english = Integer.compare(o1.value2, o2.value2);
            if(english != 0) {
                return english;
            }

            // 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
            int math = Integer.compare(o2.value3, o1.value3);
            if(math != 0) {
                return math;
            }

            // 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
            return o1.name.compareTo(o2.name);
        });

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int value1 = Integer.parseInt(st.nextToken());
            int value2 = Integer.parseInt(st.nextToken());
            int value3 = Integer.parseInt(st.nextToken());
            pq.add(new People(name, value1, value2, value3));
        }

        while(!pq.isEmpty()) {
            People poll = pq.poll();
            bw.write(poll.name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class People {
        String name;
        int value1;
        int value2;
        int value3;

        public People(String name, int value1, int value2, int value3) {
            this.name = name;
            this.value1 = value1;
            this.value2 = value2;
            this.value3 = value3;
        }
    }

}
