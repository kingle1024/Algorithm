package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOK_14606 {

    // 14606
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 0;
        if(N == 1) {
            bw.write(dp[1] + "");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        dp[2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] - dp[i-2] + 1 + dp[i-1];
        }
        bw.write(dp[N] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
