package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_2775 {
    static int[][] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = 0;
        int height = 0;
        int[][] result = new int[N][2];
        for (int i = 0; i < N; i++) {
            result[i][0] = Integer.parseInt(br.readLine());
            result[i][1] = Integer.parseInt(br.readLine());

            height = Math.max(height, result[i][0]);
            width = Math.max(width, result[i][1]);
        }
        dp = new int[height+1][width];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i+1;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j < width; j++) {
//                System.out.println(i +" "+ j);
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
//        System.out.println(dp);
        for (int i = 0; i < N; i++) {
            System.out.println(dp[result[i][0]][result[i][1]-1]);
        }

    }
}
