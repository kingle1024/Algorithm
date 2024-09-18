package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOK_1940 {

    // 1940
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        Collections.sort(list);

        int result = 0;
        int start = 0;
        int end = list.size() - 1;
        while(start < end) {
            int sum = list.get(start) + list.get(end);
            if(sum == M) {
                start++;
                result++;
            } else if(sum > M) {
                end--;
            } else {
                start++;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
