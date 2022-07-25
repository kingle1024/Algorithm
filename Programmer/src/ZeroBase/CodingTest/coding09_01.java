package ZeroBase.CodingTest;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class coding09_01 {
    static class Coding2{
        int to;
        int weight;

        public Coding2(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static int solution(int N, int[][] flight, int a, int b, int k) {
        if(flight.length == 0 || k == 0) return -1;
        int answer = 0;

        int[]dist = dijkstra(N, flight, a+1, k);
        System.out.println("result:"+dist[b+1]);
        if(dist[b+1] == Integer.MAX_VALUE){
            return -1;
        }else {
            return dist[b+1];
        }
    }
    static int[] dijkstra(int v, int[][] data, int start, int k){
        ArrayList<ArrayList<Coding2>> graph = new ArrayList<ArrayList<Coding2>>();
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }
        // 0번 인덱스부터 시작
        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]+1).add(new Coding2(data[i][1]+1, data[i][2]));
        }
        int[] dist = new int[v+1];
        for(int i=1; i<v+1; i++){
            dist[i] = Integer.MAX_VALUE;
//            System.out.println(i +" | ");
        }
        dist[start] = 0;

        PriorityQueue<Coding2> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Coding2(start, 0));
        // 방문한 횟수를
        int[] cnt = new int[v+1];

        while(!pq.isEmpty()){
            Coding2 curNode = pq.poll();
            if(dist[curNode.to] < curNode.weight){
                continue;
            }

            for(int i = 0; i < graph.get(curNode.to).size(); i++){
                Coding2 adjNode = graph.get(curNode.to).get(i);

                if(cnt[adjNode.to] < k) {
                    if (dist[adjNode.to] > curNode.weight + adjNode.weight) {
                        dist[adjNode.to] = curNode.weight + adjNode.weight;
                        pq.offer(new Coding2(adjNode.to, dist[adjNode.to]));
                        cnt[adjNode.to]++;
                    }
                    else if(curNode.to == adjNode.to && dist[curNode.to] > adjNode.weight){
                        dist[curNode.to] = adjNode.weight;
                    }
                }
            }
        }
        for (int i = 1; i < v+1; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int N = 4;
        int[][] flight = {{2,2,2}, {0,2,1},{1,3,20},{1,0,8},{2,3,1},{0,3,3}};
//        int[][] flight = {{2,2,2}};
//        int[][] flight = {{0,1,5}, {0,4,2}, {1,2,6},{1,3,4},{2,4,9},{3,1,1},{3,3,5},{4,0,2},{4,2,6}};
        int a = 1;
        int b = 3;
        int k = 2;
        solution(N, flight, a, b, k);
    }
}
