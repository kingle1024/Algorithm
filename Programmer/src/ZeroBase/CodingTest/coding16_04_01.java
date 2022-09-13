package ZeroBase.CodingTest;

import java.util.PriorityQueue;

public class coding16_04_01 {
    public static void main(String[] args) {
        int[][] heights = {{1,  2, 2},
                {3, 10, 2},
                {5,  3, 5}};
        System.out.println(new coding16_04_01().solution(
                heights
        ));
    }
    class Item implements Comparable<Item> {
        int effort;
        int i;
        int j;

        public Item(int effort, int i, int j) {
            this.effort = effort;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Item o) {
            return effort - o.effort;
        }
    }
    public int solution(int[][] heights) {
        int N = heights.length;
        int M = heights[0].length;

        // 이미 지난 길을 계속 왔다갔다 하는 것을 방지
        int[][] visited = new int[N][M];

        // (i, j) 위치까지 도달하는 데에 필요한 노력치 effort
        // effort가 낮은 케이스부터 먼저 출력하는 최소힙 사용
        PriorityQueue<Item> pq = new PriorityQueue<>();
        pq.offer(new Item(0, 0, 0));

        int maxEffort = -1;
        while (!pq.isEmpty()) {
            Item curr = pq.poll();
            maxEffort = curr.effort;
            System.out.println("[1] : "+curr.i +" "+ curr.j +" "+curr.effort);
            int i = curr.i;
            int j = curr.j;

            // 도착지에 도달하면 끝
            if (i == N-1 && j == M-1) {
                System.out.println(pq);
                break;
            }

            // 이미 지나온 길이면 pass
            if (visited[i][j] > 0) {
                continue;
            }

            // 현재 길을 지나고 있음을 체크
            visited[i][j] = 1;
            System.out.println(i +" " + j +" " +maxEffort);
            // 4가지 방향으로 각각 진행
            if (i > 0) {
                int effort = Math.abs(heights[i][j] - heights[i-1][j]);
                pq.offer(new Item(Math.max(maxEffort, effort), i-1, j));
            }
            if (i < N-1) {
                int effort = Math.abs(heights[i][j] - heights[i+1][j]);
                pq.offer(new Item(Math.max(maxEffort, effort), i+1, j));
            }
            if (j > 0) {
                int effort = Math.abs(heights[i][j] - heights[i][j-1]);
                pq.offer(new Item(Math.max(maxEffort, effort), i, j-1));
            }
            if (j < M-1) {
                int effort = Math.abs(heights[i][j] - heights[i][j+1]);
                pq.offer(new Item(Math.max(maxEffort, effort), i, j+1));
            }
        }

        return maxEffort;

    }
}
