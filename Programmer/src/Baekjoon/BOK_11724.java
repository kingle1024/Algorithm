package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_11724 {
    static boolean[] visited;
    static int[][] graph;
    static int N;
    static int M;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        graph = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }
        int startIdx = 1;
        boolean allPathTrue = false;

        while(true){
            dfs(startIdx);
            allPathTrue = true;
            for(int i=1; i<=N; i++){
                if(!visited[i]) {
                    allPathTrue = false;
                    startIdx = i;
//                    System.out.println(i);
                    cnt++;
                    break;
                }
            }
            if(allPathTrue) break;
        }
        System.out.println(cnt);
    }
    public static void dfs(int index){
        visited[index] = true;
        for(int i=1; i<=N; i++){
            if(graph[index][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
