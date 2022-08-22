package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOK_7576 {
    static int[][] map;
    static boolean[][] visited;
    static int m;
    static int n;
    static int cnt;
    static int max;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        cnt = 0;
        max = 0;
        boolean initIsZero = false;
        // 주어진 숫자를 배열에 넣어주는 부분
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) initIsZero = true;
            }
        }

        // 전체 배열을 탐색하면서 1이 포함된 위치를 Queue에 넣어준다.
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1){
                    arr.add(new int[]{i,j});
                }
            }
        }

        // BFS 탐색 시작
        bfs(arr);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }

        // 탐색 완료 후, 숫자 0이 있으면 모두 익지 않았기 때문에 false 처리해준다.
        boolean isZero = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    isZero = true;
                    break;
                }
            }
            if(isZero) break;
        }

        // 예외 처리 해주는 부분
        if(!initIsZero){
            System.out.println("0");
            return;
        }
        if(isZero){
            System.out.println("-1");
            return;
        }

        System.out.println(max-1);
    }
    public static void bfs(ArrayList<int []> position){
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<position.size(); i++){
            q.add(new int[]{position.get(i)[0],position.get(i)[1]});
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!q.isEmpty()){
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                // 범위를 벗어날 때 continue;
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                // 다음 위치가 0이 아닐 때, 방문했을 때 continue;
                if(map[nextX][nextY] != 0|| visited[nextX][nextY])
                    continue;

                q.add(new int[]{nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
                // max 값을 갱신해줌
                max = Math.max(max, map[nextX][nextY]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
