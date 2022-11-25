package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_2229 {
    static int[][] dp;
    static int[] dp2;
    static int max;
    public static void main(String[] args) throws IOException {
//        solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] s = new int[n + 1], d = new int[n + 1];

        String[] line = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            int max = 0, min = 10001;
            s[i] = Integer.parseInt(line[i - 1]);

            for (int j = i; j > 0; j--) {
                max = Math.max(max, s[j]);
                min = Math.min(min, s[j]);
                d[i] = Math.max(d[i], max - min + d[j - 1]);
            }
        }

        System.out.println(d[n]);
        br.close();

    }
    static int[] arr;
    public static void solution2() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
    public static void recur(int i){
        // 다음을 탐색했을 때에 합칠지, 따로 갈지에 대해서 어떻게 판단을 하는가?
        // -> 재귀로 도나?
        // 재귀를 이용한다면,
        // ( ) [ ] { }인 경우에 다음을 탐색하면 {부터 시작하는 것을 어떻게 알 수 있는가?
        dp2[i] = arr[i];

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
        for (int i = 0; i < 2; i++) {
            System.out.println(dp[result[i][0]][result[i][1]-1]);
        }

    }
}
