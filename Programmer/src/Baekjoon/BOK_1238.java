package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOK_1238 {
    static class Bok_1238{
        int to;
        int weight;

        public Bok_1238(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());

        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());
//        System.out.println(V +" " + E +" " + K);

        int[][] arr = new int[E][3];

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[]start = new int[V+1];
        int[]temp = new int[V+1];

        for(int i=1; i<V+1; i++){
            temp = dijkstra(V, arr, i);
            start[i] = temp[K];
        }

        int[]end = new int[V+1];
        end = dijkstra(V, arr, K);

        for (int i = 0; i < V+1; i++) {
            System.out.println(end[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<V+1; i++){
            if(max < start[i] + end[i]){
                max = start[i] + end[i];
            }
        }
        System.out.println("============");
        for (int i = 0; i < V+1; i++) {
            System.out.println(start[i]);
        }

        System.out.println(max);
    }
    static int[] dijkstra(int v, int[][] data, int start){
        ArrayList<ArrayList<Bok_1238>> graph = new ArrayList<ArrayList<Bok_1238>>();
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Bok_1238(data[i][1], data[i][2]));
        }
        int[] dist = new int[v+1];
        for(int i=1; i<v+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        PriorityQueue<Bok_1238> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Bok_1238(start, 0));
        while(!pq.isEmpty()){
            Bok_1238 curNode = pq.poll();
            if(dist[curNode.to] < curNode.weight){
                continue;
            }

            for(int i = 0; i < graph.get(curNode.to).size(); i++){
                Bok_1238 adjNode = graph.get(curNode.to).get(i);

                if(dist[adjNode.to] > curNode.weight + adjNode.weight){
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Bok_1238(adjNode.to, dist[adjNode.to]));
                }
            }
        }

//        for (int i = 1; i < v+1; i++) {
//            if(dist[i] == Integer.MAX_VALUE){
//                System.out.println("INF");
//            }else{
//                System.out.println(dist[i]);
//            }
//        }
        return dist;
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
