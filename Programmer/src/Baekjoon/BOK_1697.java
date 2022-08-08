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
        if(x > y) rNum = true; // x,y가 숫자가 다를때

        // 계산을 줄이기 위해 17에서 5로 가는 경우는 빼주어 바로 return
        // 이렇게 되면 while문을 돌지 않아도 됨 즉, 계산을 12번 해야할 걸 1번만 함
        // 입력으러 주어진 숫자가 100,000 1이었으면 10만번할걸 1번만 함
        if(rNum) return x-y;

        while(!q.isEmpty()){
            People move = q.poll(); // 사람의 위치를 꺼냄

            for(int i=0; i<3; i++){ // -1, +1, *2
                int nextX; // 다음 x 위치
                int time = move.time; // People이 갖고 있는 현재까지 소요된 시간
                if(i == 2){ // 2번째일때에 *2이므로 따로 처리해줌
                    nextX = move.x * dx[i];
                }else{ // 나머지는 -1, +1
                    nextX = move.x + dx[i];
                }

                // 만약 만나면 바로 return 해줌
                if(nextX == y) return time; // *2 *2 *2 *2 *2 +1 -1

                // contine없이 범위에 들어왔을 때에 People을 q에 넣어줌
                if(nextX >= 0 && nextX < visited.length && !visited[nextX]) {
                    q.add(new People(nextX, time + 1));
//                    visited[nextX] = true;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
