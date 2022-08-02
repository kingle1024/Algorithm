package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOK_5427 {
    static String[][] map;
    static boolean[][] visited;
    static boolean es;
    static int result;
    static int h;
    static int w;
    static int dx[];
    static int dy[];
    static class Man{
        int x;
        int y;
        int time;

        public Man(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static class Fire{
        int x;
        int y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        ArrayList<Integer> array = new ArrayList<>();
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        Man m;
        for(int s = 0; s < cnt; s++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new String[h][w];
            visited = new boolean[h][w];

            Queue<Man> q = new LinkedList<>();
            Queue<Fire> fire = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                String str = br.readLine();

                for (int j = 0; j < w; j++) {
                    char c = str.charAt(j);
                    map[i][j] = c + "";
                    if (c == '@') {
                        q.add(new Man(i, j, 1));
                    } else if (c == '*') {
                        fire.add(new Fire(i,j));
                    }
                }
            }

            array.add(bfs(q, fire));
        }

        for(int i=0; i<array.size(); i++){
            if(array.get(i) == -1){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(array.get(i));
            }
        }
    }
    public static int bfs(Queue<Man> q, Queue<Fire> fire){
        result = -1;
        es = false;
        Man checkPos = q.poll();

        if (checkPos.y == 0 || checkPos.y == w - 1){
            return 1;
        }
        if(checkPos.x == 0 || checkPos.x == h-1) {
            return 1;
        }

        q.add(checkPos);

        while(!q.isEmpty()) {
            burn(fire);
            escape(q);
            if(es) break;
        }
        if(es){
            return result;
        }else{
            return -1;
        }
    }

    public static void escape(Queue<Man> q){
        int qSize = q.size();
        for(int k = 0; k < qSize; k++) {
            Man now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            visited[nowX][nowY] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // 범위를 벗어날 때
                if (nextX < 0 || nextY < 0 || nextX > h || nextY > w)
                    continue;
                // 이미 방문했거나, 막혀있는 경우
                if (visited[nextX][nextY] || map[nextX][nextY].equals("#"))
                    continue;
                // 탈출하는 경우
                if ((nextX == h - 1 || nextY == w - 1 || nextX == 0 || nextY == 0) && map[nextX][nextY].equals(".")) {
                    es = true;
                    result = now.time+1;
                    break;
                }
                // 일반적인 이동 경우
                visited[nextX][nextY] = true;
                q.add(new Man(nextX, nextY, now.time + 1));
            }
            if(es)break;
        }
    }

    public static void burn(Queue<Fire> fire){
        int fireCnt = fire.size();

        for(int i=0; i<fireCnt; i++) {
            if(fire.size() < 1) break;
            Fire fireNow = fire.poll();
            int fireNowX = fireNow.x;
            int fireNowY = fireNow.y;
            visited[fireNowX][fireNowY] = true;
            for(int j=0; j<4; j++) {
                int fireNextX = fireNowX + dx[j];
                int fireNextY = fireNowY + dy[j];
                // 범위를 벗어날때
                if (fireNextX < 0 || fireNextY < 0 || fireNextX >= h || fireNextY >= w)
                    continue;
                // 방문한 경우
                if (visited[fireNextX][fireNextY])
                    continue;

                // 일반적인 경우
                if(map[fireNextX][fireNextY].equals(".")) {
                    visited[fireNextX][fireNextY] = true;
                    fire.add(new Fire(fireNextX, fireNextY));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
