package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_1049 {

    // 1049
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        final int sixCnt = N / 6;
        final int onCnt = N % 6;
        int minSixPrice = Integer.MAX_VALUE;
        int minOnePrice = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minSixPrice = Math.min(minSixPrice, Integer.parseInt(st.nextToken()));
            minOnePrice = Math.min(minOnePrice, Integer.parseInt(st.nextToken()));
        }

        final int mixPrice = minSixPrice * sixCnt + minOnePrice * onCnt;
        final int onlySixPrice = (sixCnt+1) * minSixPrice;
        final int onlyOnePrice = minOnePrice * N;

        bw.write(Math.min(onlyOnePrice, Math.min(mixPrice, onlySixPrice)) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
