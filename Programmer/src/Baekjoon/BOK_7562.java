package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOK_7562 {
    static int N;
    static boolean[][] visited;
    static class People{
        int x;
        int y;
        int cnt;

        public People(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        for(int i=0; i<loop; i++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            visited = new boolean[N][N];

            System.out.println(bfs(startX, startY, endX, endY));
        }
    }
    public static int bfs(int sx, int sy, int ex, int ey){
        if(sx == ex && sy == ey) return 0;
        int dx[] = {1, 2, 2, 1, -1, -2, -1, -2};
        int dy[] = {2, 1, -1, -2, 2, 1, -2, -1};
        visited[sx][sy] = true;
        Queue<People> q = new LinkedList<>();
        q.add(new People(sx, sy, 0));

        while(!q.isEmpty()) {
            People p = q.poll();
            int cnt = p.cnt;
            cnt += 1;
            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if (nx == ex && ny == ey) {
//                    System.out.println("왔다 " + nx + " " + ny);
                    return cnt;
                }

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;


                visited[nx][ny] = true;

                q.add(new People(nx, ny, cnt));
            }
        }
        return 0;
    }
}
// why 1이 더 높은가..
