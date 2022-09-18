package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_1068 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] tree = new int[N][N];
        int temp = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++){
            int num1 = Integer.parseInt(st.nextToken());
            tree[i][num1] = tree[num1][i] = 1;
        }
//        System.out.println(tree);
        int deleteNum = Integer.parseInt(br.readLine());
        for(int i=0; i<tree.length; i++){
            tree[deleteNum][i] = tree[i][deleteNum] = 0;
        }
//        System.out.println(tree);
        cnt = 0;
        visited = new boolean[N];
        dfs(tree,0, N);
        System.out.println(tree);
        System.out.println(cnt);
    }
    static int cnt;
    static boolean visited[];
    public static void dfs(int[][] tree, int x, int N){
        boolean isZero = false;
        for(int j=0; j<N; j++){
            int num = tree[x][j];
            if(num != 0 && !visited[num]) {
                visited[num] = true;
                dfs(tree, num, j);
                isZero = true;
            }
        }
        if(!isZero) {
            cnt++;
        }
    }
}
