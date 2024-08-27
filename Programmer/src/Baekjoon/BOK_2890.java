package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOK_2890 {

    // 2890
    public static void main(String[] args) throws IOException {
        process();
    }

    static class People {
        int idx;
        int score;
        int rank;

        public People(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        List<People> list = new ArrayList<>();
        int[] arr = new int[C+1];
        // 데이터 input
        for (int i = 1; i <= R; i++) {
            String s = br.readLine();
            for (int j = s.length()-2; j >= 1; j--) {
                char c = s.charAt(j);
                if(s.charAt(j) != '.') {
                    int idx = c - '0';
                    arr[idx] = s.length() - j - 1;
                    list.add(new People(idx, s.length() - j - 1));
                    break;
                }
            }
        }
        // 점수 순으로 정렬 
        list.sort(Comparator.comparingInt(o -> o.score));
        int rank = 1;
        list.get(0).rank = 1;
        // 점수 같으면 동일한 rank 처리 
        for(int i = 1; i < list.size(); i++) {
            if (list.get(i).score != list.get(i - 1).score) {
                rank++;
            }
            list.get(i).rank = rank;
        }
        // idx 순으로 정렬
        list.sort(Comparator.comparingInt(o -> o.idx));
        
        // 결과 출력
        for(People p : list) {
            bw.write(p.rank + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
