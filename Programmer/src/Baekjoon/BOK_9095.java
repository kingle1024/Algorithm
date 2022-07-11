package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOK_9095 {
    public static void main(String[] args) throws Exception{
        solution();
    }
    static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int[] arr = new int[T];
        int[] result = new int[T];
        for(int i=0; i<T; i++){
            arr[i] = Integer.parseInt(br.readLine());
            result[i] = dp(dp, arr[i]);
        }

        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }
    }
    static int dp(int[] dp, int n){
        for(int i=4; i<=n; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
}
