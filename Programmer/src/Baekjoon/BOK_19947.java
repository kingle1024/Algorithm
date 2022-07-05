package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_19947 {
    static int result = 0;
    static int origin;
    static long result2 = 0;
    static long origin2;
    static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        result = H;
        origin = Y;

        System.out.println(dynamic(H, Y));
    }
    public static int dynamic(int H, int Y){
        int[]dp = new int[11];
        dp[0] = H;
        dp[1] = (int)(H*1.05);
        dp[2] = (int)(dp[1]*1.05);
        dp[3] = (int)(H*1.2);
        int num = Y;

        for(int i=4; i<=Y; i++){
            dp[i] = (int)(dp[i-1] * 1.05);
            if(i > 2){
                dp[i] = Math.max((int)(dp[i-3] * 1.2), dp[i]);
            }
            if(i > 4){
                dp[i] = Math.max((int)(dp[i-5] * 1.35), dp[i]);
            }
        }
        return dp[Y];
    }

    public static void main(String[] args) throws Exception{
//        for(int i=10; i>=0; i--){
//            solution2(99876, i);
//            System.out.println();
//        }
        solution();
    }
}
