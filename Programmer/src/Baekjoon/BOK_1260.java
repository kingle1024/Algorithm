package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOK_1260 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    static int[][] map;
    static boolean[] visited;
    static int N;
    static int M;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }
        dfs(start);
        System.out.println();

        visited = new boolean[N+1];

        bfs(start);
    }

    public static void dfs(int x){
        visited[x] = true;
        System.out.print(x+" ");
        for (int i = 1; i <= N; i++) {
            if(map[x][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        System.out.print(x +" ");
        visited[x] = true;

        while(!q.isEmpty()){
            x = q.poll();
            for (int i = 1; i <= N; i++) {
                if(map[x][i] == 1 && !visited[i]){
                    visited[i] = true;
                    System.out.print(i +" ");
                    q.add(i);
                }
            }
        }
    }
}
