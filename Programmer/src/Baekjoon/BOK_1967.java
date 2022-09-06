import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOK_1967 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    static boolean[] visited;
    static int max;
    static int maxIdx;
    static int sum;
    static int n;
    static List<Node>[] totalList;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        totalList = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            totalList[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeValue = Integer.parseInt(st.nextToken());
            int toValue = Integer.parseInt(st.nextToken());
            int weightValue = Integer.parseInt(st.nextToken());

            totalList[nodeValue].add(new Node(toValue, weightValue));
            totalList[toValue].add(new Node(nodeValue, weightValue));
        }
        // 1 { ... , ... , ... }
        // 2 { ... , ... , ... }
        // 3 { ... , ... , ... }
        // 4 { ... , ... , ... }
        // 5 {
        max = 0;
        maxIdx = 0;

        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(max);
    }
    public static void dfs(int idx, int cnt){
//        System.out.println(idx +" "+cnt);
        for(Node node : totalList[idx]){
            if(!visited[node.to]){
                visited[node.to] = true;
                dfs(node.to, cnt+node.weight);
            }
        }
        max = Math.max(max, cnt);
    }
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
