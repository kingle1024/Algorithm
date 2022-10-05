package BookStudy.week3_day1.bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOK_24479_1 {
    static int N;
    static int M;
    static boolean[] num;
    static int[] result;
    static int idx;
    static ArrayList<PriorityQueue<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 간선 - 줄기가 되는 선
        int start = Integer.parseInt(st.nextToken());
        num = new boolean[N+1];
        result = new int[N];

        graph = new ArrayList<>();
        for (int i = 1; i <= N+1; i++) {
            graph.add(new PriorityQueue<>());
        }

        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(start);
        for(int i=0; i<N; i++){
            System.out.println(result[i]);
        }
    }
    public static void dfs(int x){
        if(num[x]) return;
        num[x] = true;
//        System.out.println(x);
        result[x-1]=++idx;
        PriorityQueue<Integer> queue = graph.get(x);

        while(!queue.isEmpty()){
            int nx = queue.poll();

            dfs(nx);
        }
    }
}
