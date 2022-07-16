package ZeroBase.Class;

import java.util.ArrayList;

public class Part2_Chapter04_Class16 {
    static class Node16{
        int to;
        int weight;

        public Node16(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static void dijkstra(int v, int[][] data, int start){
        ArrayList<ArrayList<Node16>> graph = new ArrayList<>();
        for(int i=0; i<v+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<data.length; i++){ // 그래프 구성
            graph.get(data[i][0]).add(new Node16(data[i][1], data[i][2]));
        }

        int[] dist = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        boolean[] visited = new boolean[v+1];

        for (int i = 0; i < v; i++) { // 모든 노드들을 탐색하면서 거리 정보를 업데이트
            int minDist = Integer.MAX_VALUE;
            int curIdx = 0;
            for (int j = 1; j < v+1; j++) { // 최소 정보를 갖고 있는 노드로 업데이트 처리
                if(!visited[j] && dist[j] < minDist){
                    minDist = dist[j];
                    curIdx = j;
                }
            }
            visited[curIdx] = true;

            // 선택된 노드의 인접 노드에 대해서 거리 갱신
            // 인접 노드의 사이즈를 얻어옴
            // 모든 노드를 경유하면서 업데이트가 됨
            for (int j = 0; j < graph.get(curIdx).size(); j++) {
                Node16 adjNode = graph.get(curIdx).get(j); // 해당 인접 노드를 하나씩 가져와서 거리 정보 업데이트
                if(dist[adjNode.to] > dist[curIdx] + adjNode.weight){ // 현재와 거리와 해당 부분을 거쳐서 가는 비용이 작으면 업데이트
                    dist[adjNode.to] = dist[curIdx] + adjNode.weight;
                }
            }
        }

        for (int i = 1; i < v+1; i++) {
            if(dist[i] == Integer.MAX_VALUE){ // 거리 정보가 업데이트 되지 않고 MAX_VALUE로 남아있으면
                System.out.print("INF ");
            }else {
                System.out.print(dist[i] +" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] data = {{1,2,2}, {1,3,3}, {2,3,4},{2,4,5}, {3,4,6}, {5,1,1}};
        dijkstra(5, data, 1);
    }

}
