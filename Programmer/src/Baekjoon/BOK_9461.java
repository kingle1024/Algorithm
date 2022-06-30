package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOK_9461 {
    static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[T];
        for(int i=0; i<T; i++){
            arr[i] = dynamic(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    static long[] dp = new long[105];
    static long dynamic(int n){
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4; i<=n; i++){
            dp[i] = dp[i-3]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) throws Exception{
        solution();
    }
}
