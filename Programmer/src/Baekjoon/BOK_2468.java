package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_2468 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    static boolean[][] visited;
    static int N;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int max = -1;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > max) max = map[i][j];
            }
        }

        int result = -1;
        for (int i = 0; i <= max; i++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(dfs(map, j, k, i)){
                        System.out.println(j+" "+k +" "+i);
                        cnt += 1;
                    }
                }
            }
            System.out.println(i+" "+cnt);
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }

    public static boolean dfs(int[][] map, int x, int y, int depth){
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        boolean check = false;
        if(map[x][y] <= depth) return false;
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if(nowX < N && nowY < N && nowX >= 0 && nowY >=0){
                if(!visited[nowX][nowY] && map[nowX][nowY] > depth){
                    check = true;
                    visited[nowX][nowY] = true;
                    dfs(map, nowX, nowY, depth);
                }
            }
        }
        return check;
    }

}
