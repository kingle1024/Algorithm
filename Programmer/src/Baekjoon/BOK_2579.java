package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_2579 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    static int[] arr;
    static int[] dp;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        if(N == 1){
            System.out.println(dp[0]);
            return;
        }

        dp[1] = arr[0] + arr[1];
        if(N == 2){
            System.out.println(dp[1]);
            return;
        }

        dp[2] = Math.max(arr[1]+arr[2], arr[0] + arr[2]);
        if(N == 3){
            System.out.println(dp[2]);
            return;
        }

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(arr[i] + dp[i-2], arr[i] + arr[i-1] + dp[i-3]);
        }
        System.out.println(dp[N-1]);
    }
}
