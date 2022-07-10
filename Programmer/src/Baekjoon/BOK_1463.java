package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_1463 {
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        if(N > 0){
            dp[1] = 0;
        }
        if(N > 1) {
            dp[2] = 1;
        }
        if(N > 2){
            dp[3] = 1;
        }
        for(int i=4; i<=N; i++){
            int num = -1;

            if(i % 6 == 0){
                num = Math.min(dp[i/3]+1, dp[i/2]+1);
            }else if(i % 3 == 0){
                num = dp[i/3]+1;
//                System.out.println("[1] "+i +" " + dp[i/3]);
            }else if(i % 2 == 0){
                num = dp[i/2]+1;
//                System.out.println("[2] "+i +" " + dp[i/2]);
            }
            // 29의 경우.. -1하고
            if(num != -1) {
                dp[i] = Math.min(num, dp[i - 1]+1);
            }else{
                dp[i] = dp[i - 1]+1;
            }
//            System.out.println(i+" " +dp[i]);
        }

        System.out.println(dp[N]);
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
    // 99 -> 33 -> 11 -> 10
    // 50 -> 25 -> 24 ->
    // 14 -> 7 -> 6 -> 3 -> 1
}
