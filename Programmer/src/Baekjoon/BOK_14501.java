package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_14501 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    static int[][] arr;
    static int[] dp;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N+1][2];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            if(i + arr[i][0] <= N) {
                if(dp[i] != 0)
                    dp[i + arr[i][0] -1] = Math.max(dp[i + arr[i][0]-1], dp[i] + arr[i][1]);
            }
        }
        System.out.println(dp[N]);
    }
}
