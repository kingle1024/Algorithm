package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOK_2822 {

   static class People {
        int score;
        int idx;

        People(int score, int idx) {
            this.score = score;
            this.idx = idx;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<People> queue = new PriorityQueue<>(
            Comparator.comparingInt((People p) -> p.score).reversed()
        );
        for (int i = 1; i <= 8; i++) {
            int num = Integer.parseInt(br.readLine());
            queue.add(new People(num, i));
        }

        int result = 0;
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        for (int i = 0; i < 5; i++) {
            People people = queue.poll();
            result += people.score;
            queue2.add(people.idx);
        }

        bw.write(result +"\n");
        while(!queue2.isEmpty()) {
            bw.write(queue2.poll() + " ");
        }

        bw.flush();
        bw.close();
    }

}
