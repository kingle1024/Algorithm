package ZeroBase.CodingTest;

import java.util.PriorityQueue;

public class coding16_04 {
    public static void main(String[] args) {
        int[][]heights = {
                {1, 2, 2},
                {3, 10, 2},
                {5, 3, 5}
        };
        solution(heights);
    }
    static boolean visited[][];
    public static int solution(int[][] heights){
        visited = new boolean[heights.length][heights.length];

        System.out.println(bfs(heights));
        return 1;
    }
    public static int bfs(int[][] heights){
        PriorityQueue<People_16> priorityQueue = new PriorityQueue<>();
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        int length = heights.length;
        priorityQueue.offer(new People_16(0, 0, 0));

        int maxEffort = -1;
        while(!priorityQueue.isEmpty()){
            People_16 p = priorityQueue.poll();
            maxEffort = p.distance;

            if(p.x == length-1 && p.y == length-1) break;

            if(visited[p.x][p.y]) continue;
            visited[p.x][p.y] = true;

            System.out.println("[1] : "+p.x +" "+ p.y+" "+ p.distance);


            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= length || ny >= length) continue;

                int effort = Math.abs(heights[p.x][p.y] - heights[nx][ny]);
                int max = Math.max(maxEffort, effort);
                System.out.println(nx +" "+ ny +" "+ max);
                priorityQueue.offer(new People_16(nx, ny, max));
            }
        }
        return maxEffort;
    }
    static class People_16 implements Comparable<People_16>{
        int x;
        int y;
        int distance;

        public People_16(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(People_16 o) {
            return distance - o.distance;
        }
    }
}
