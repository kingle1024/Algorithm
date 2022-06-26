package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOK_1904 {
    static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(dynamic(N));
    }
    static long[] dp = new long[10000002];
    static long dynamic(int n){
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1])%15746;
        }
        return dp[n];
    }
    public static void main(String[] args) throws Exception{
        solution();
    }
}
