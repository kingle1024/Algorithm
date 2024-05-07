package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOK_1417 {
    public static class People {
        private int score;

        public People(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int loop = Integer.parseInt(br.readLine());
        if(loop == 1) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }
        PriorityQueue<People> pq = new PriorityQueue<>(Comparator.comparingInt(People::getScore).reversed());
        People myPeople = null;
        for (int i = 0; i < loop; i++) {
            int score = Integer.parseInt(br.readLine());
            if(i == 0) {
                myPeople = new People(score);
            } else {
                pq.add(new People(score));
            }
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            People poll = pq.poll();
            if(poll.score < myPeople.getScore()) {
                bw.write(String.valueOf(cnt));
                break;
            } else {
                cnt++;
                poll.score -= 1;
                myPeople.score += 1;
                pq.add(poll);
            }

        }

        bw.flush();
        bw.close();
    }
}
