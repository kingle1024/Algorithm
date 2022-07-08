package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOK_1912 {
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        int[] arr = new int[n];
        while(st.hasMoreTokens()){
            arr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }
//        arr = new int[]{2, 1, -4, 3, 4, -4, 6, 5, -5, 1};
//        arr = new int[]{-1, -2, -3, -4, -5};

        System.out.println(dp(arr));
    }
    static long dp(int[] arr){
        if(arr.length == 1) return arr[0];
        long[] dp = new long[arr.length+1];
        dp[0] = arr[0];
        long result = dp[0];
        for(int i=1; i<arr.length; i++){
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            result = Math.max(result, dp[i]);
//            System.out.println(dp[i]);
        }
//        System.out.println(result);
        return result;
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}

