package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_1932_1 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int idx = 0;
        int[][] dp = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            idx = 0;
            while(st.hasMoreTokens()){
                arr[i][idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        }

        for(int i=0; i<N; i++){
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                }
            }
        }
        int max = dp[N-1][0];
        for(int i=1; i<N; i++){
            max = Math.max(max, dp[N-1][i]);
        }
        System.out.println(max);
    }
}
