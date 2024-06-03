package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOK_9237 {

    // 9237
    public static void main(String[] args) throws IOException {
        extracted();
    }

    private static void extracted() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Collections.reverseOrder());

        int max = Integer.MIN_VALUE;
        final int size = list.size();
        for (int i = 0; i < size; i++) {
            max = Math.max(list.get(i) + (i+1), max);
        }
        max += 1;

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
    }

}
