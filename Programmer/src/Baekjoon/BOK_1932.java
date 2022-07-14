package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_1932 {
    static int n;
    static Integer[][]dp;
    static int[][]arr;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Integer[n][n];
        arr = new int[n][n];
        
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            dp[n-1][i] = arr[n-1][i];
        }

        find(0,0);
        System.out.println(dp[0][0]);
    }
    static int find(int depth, int idx){
        if(depth == n-1){
//            System.out.println("[2] "+depth+" " +idx+" "+dp[depth][idx]);
            return dp[depth][idx];
        }

        if(dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
//            System.out.println("[1] "+depth+" " +idx+" "+dp[depth][idx]);
        }

        return dp[depth][idx];
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
