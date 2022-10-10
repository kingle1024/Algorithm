package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BOK_18352 {
    static int N;
    static int M;
    static int K;
    static int X;
    static int[] visited;
    static List<Queue<Integer>> graph;
    static List<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new int[N+1];
        result = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int data = Integer.parseInt(st.nextToken());
            graph.get(node).add(data);
        }
        search(X);
        Collections.sort(result);
        StringBuffer sb = new StringBuffer();
        if(result.size() == 0){
            sb.append("-1");
        }else {
            for (int i = 0; i < result.size(); i++) {
                if(result.get(i) == X) continue;
                sb.append(result.get(i)+"\n");
            }
            if(sb.length() == 0) sb.append("-1");
        }
        System.out.print(sb);
    }
    public static void search(int start){
        Queue<Integer> q = graph.get(start);
        Queue<People> doing = new LinkedList<>();

        // 처음 모두 넣기
        while (!q.isEmpty()){
            int nextData = q.poll();
            doing.add(new People(nextData, 1));
            visited[nextData] += 1;
        }

        while (!doing.isEmpty()){
            People p = doing.poll();
            int nextData = p.next;
            if(p.cnt == K){
                result.add(nextData);
                continue;
            }

            Queue<Integer> list = graph.get(nextData);

            // 이동경로 모두 넣기
            while(!list.isEmpty()){
                int next = list.poll();
                if(visited[next] != 0 && p.cnt+1 >= visited[next]) continue;
                doing.add(new People(next, p.cnt+1));
            }
        }
    }
    static class People{
        int next;
        int cnt;

        public People(int next, int cnt) {
            this.next = next;
            this.cnt = cnt;
        }
    }
}
