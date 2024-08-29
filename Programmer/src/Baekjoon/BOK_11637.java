package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BOK_11637 {

    // 11637
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> votes = new ArrayList<>();
            int sum = 0;

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(br.readLine());
                votes.add(num);
                sum += num;
            }

            // 정렬된 투표 리스트 생성
            List<Integer> sortedVotes = new ArrayList<>(votes);
            Collections.sort(sortedVotes);

            if (sortedVotes.get(sortedVotes.size() - 1).equals(sortedVotes.get(sortedVotes.size() - 2))) {
                bw.write("no winner\n");
            } else {
                int winnerValue = sortedVotes.get(sortedVotes.size() - 1);
                int winnerIndex = votes.indexOf(winnerValue);
                String winnerType = (winnerValue > sum / 2) ? "majority" : "minority";
                bw.write(winnerType + " winner " + (winnerIndex + 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
