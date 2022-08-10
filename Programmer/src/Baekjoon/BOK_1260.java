package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_1260 {
    static int[][] graph;
    static int N;
    static int M;
    static int V;
    static StringBuffer sb = new StringBuffer();
    static boolean[] dfsVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 최대 숫자
        M = Integer.parseInt(st.nextToken()); // for문 갯수
        V = Integer.parseInt(st.nextToken()); // 탐색 시작 위치

        graph = new int[N+1][N+1];
        dfsVisited = new boolean[N+1];
        for(int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        dfs(V);
        System.out.println(sb);
    }
    static void dfs(int index){
        dfsVisited[index] = true;
        sb.append(index+" ");

        for(int i=1; i<=N; i++){
            if(graph[index][i] == 1 && !dfsVisited[i]) {
                System.out.println(index);
                dfs(i);
            }
        }
    }
}
