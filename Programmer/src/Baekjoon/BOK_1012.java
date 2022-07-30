package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOK_1012 {
    static int[][] map;
    static boolean [][] visited;
    static int m;
    static int n;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> array = new ArrayList<>();

        for(int idx=0; idx<T; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int loop = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            visited = new boolean[m][n];
            for (int i = 0; i < loop; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (bfs(i, j)) {
                        cnt++;
//                        System.out.println(i +" "+j);
                    }
                }
            }
//            System.out.println(cnt);
//            for (int i = 0; i < m; i++) {
//               for (int j = 0; j < n; j++) {
//                   System.out.print(map[i][j] + " ");
//               }
//               System.out.println();
//            }
            array.add(cnt);
        }
        for(int i=0; i<array.size(); i++){
            System.out.println(array.get(i));
        }

    }
    public static boolean bfs(int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        boolean check = false;

        while(!q.isEmpty()){
            int[] coordinate = q.poll();
            int nowX = coordinate[0];
            int nowY = coordinate[1];
            if(map[nowX][nowY] == 0) continue;
            if(map[nowX][nowY] == 1) check = true;
            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n)
                    continue;
                if(map[nextX][nextY] == 0 || visited[nextX][nextY])
                    continue;

                q.add(new int[]{nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
//                check = true;
            }
        }
        return check;
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
