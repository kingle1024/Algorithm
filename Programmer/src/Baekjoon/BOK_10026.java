package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_10026 {

    static boolean[][] visited;
    static int N;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        int[][] handicapGraph = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                if(c == 'R'){
                    graph[i][j] = 0;
                    handicapGraph[i][j] = 0;
                }else if(c == 'G'){
                    graph[i][j] = 1;
                    handicapGraph[i][j] = 0;
                }else if(c == 'B'){
                    graph[i][j] = 2;
                    handicapGraph[i][j] = 2;
                }
            }
        }
        // DDDDDD

        // R -> Red // G -> Green
        // B -> Blue

        int cnt = 0;
        int handicapCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    if (graph[i][j] == 0) {
                        dfs(i, j, 0, graph);
                        cnt++;
                    } else if (graph[i][j] == 1) {
                        dfs(i, j, 1, graph);
                        cnt++;
                    } else if (graph[i][j] == 2) {
                        dfs(i, j, 2, graph);
                        cnt++;
                    }
                }
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    if (handicapGraph[i][j] == 0) {
                        dfs(i, j, 0, handicapGraph);
                        handicapCnt++;
                    }else if (handicapGraph[i][j] == 2) {
                        dfs(i, j, 2, handicapGraph);
                        handicapCnt++;
                    }
                }
            }
        }

//        System.out.println(handicapGraph +" " + visited);
        System.out.println(cnt +" "+handicapCnt);

    }
    public static void dfs(int x, int y, int findNum, int[][] graph){
        visited[x][y] = true;
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
            if(visited[nextX][nextY]) continue;

            if(graph[nextX][nextY] == findNum) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, findNum, graph);
            }
        }
    }



    public static void main(String[] args) throws IOException {
        solution();
    }

}
