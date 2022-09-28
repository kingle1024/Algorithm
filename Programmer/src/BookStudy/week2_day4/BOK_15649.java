package BookStudy.week2_day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_15649 {
    static boolean visited[];
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // n까지 진행
        m = Integer.parseInt(st.nextToken()); // 자릿수
        visited = new boolean[n+1];
        arr = new int[m];
        recur(0);
    }
    public static void recur(int depth){
        if(depth == m){
            print(arr);
            return;
        }
        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            arr[depth] = i;
            visited[i] = true;
            recur(depth + 1);
            visited[i] = false;
        }
    }
    static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
}
