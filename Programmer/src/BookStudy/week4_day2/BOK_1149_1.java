package BookStudy.week4_day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOK_1149_1 {
    static int map[][];
    static int dp[][];
    static int N;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        dp = new int[N][3];

        min = Integer.MAX_VALUE;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];
        int r = dfs(N-1, 0);
        int g = dfs(N-1, 1);
        int b = dfs(N-1, 2);
//        System.out.println(r +" " + g+" "+ b);
        System.out.println(Math.min(Math.min(r,g), b));

    }
    public static int dfs(int floor, int color){
        if(dp[floor][color] == 0){
            if(color == 0) {
                dp[floor][0] = Math.min(dfs(floor-1,1), dfs(floor-1,2)) + map[floor][0];
            }else if(color == 1){
                dp[floor][1] = Math.min(dfs(floor-1,0), dfs(floor-1,2)) + map[floor][1];
            }else if(color == 2){
                dp[floor][2] = Math.min(dfs(floor-1,0), dfs(floor-1,1)) + map[floor][2];
            }
        }
        return dp[floor][color];
    }

}
