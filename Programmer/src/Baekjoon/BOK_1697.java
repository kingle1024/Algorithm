package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOK_1697 {
    static int[] map;
    static boolean[] visited;
    static class People{
        int x;
        int time;

        public People(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        System.out.println(bfs(x,y));
    }

    public static int bfs(int x, int y){
        People p = new People(x, 1);
        Queue<People> q = new LinkedList<>();
        q.add(p);

        int[] dx = new int[]{-1, 1, 2};
        boolean rNum = false;
        if(x == y) return 0;
        if(x > y) rNum = true;
        if(rNum) return x-y;

        while(!q.isEmpty()){
            People move = q.poll();

            for(int i=0; i<3; i++){
                int nextX;
                int time = move.time;
                if(i == 2){
                    nextX = move.x * dx[i];
                }else{
                    nextX = move.x + dx[i];
                }

                // 만약 만나면
                if(nextX == y) return time;
                if(nextX >= 0 && nextX < visited.length && !visited[nextX]) {
                    q.add(new People(nextX, time + 1));
                    visited[nextX] = true;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
