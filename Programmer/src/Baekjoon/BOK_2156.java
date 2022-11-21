package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_2156 {
    // https://www.youtube.com/watch?v=cJFxrfJa_QM
    public static void main(String[] args) throws IOException {
        solution();
    }
    static int[] arr;
    static int[] dp;
    static int max;
    static int N;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        max = -1;
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        if(N == 1) {
            System.out.println(dp[0]);
            return;
        }
        dp[2] = Math.max(arr[0] + arr[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));
        if(N == 2) {
            System.out.println(dp[1]);
            return;
        }

        for(int i=3; i<N; i++){
            dp[i] = Math.max(dp[i-1],
                    Math.max(arr[i] + arr[i-1] + dp[i-3], arr[i] + dp[i-2])
            );
            max = Math.max(dp[i], max);
        }
        // o x o
        // x o o
        // o o x
        System.out.println(max);
    }


}
