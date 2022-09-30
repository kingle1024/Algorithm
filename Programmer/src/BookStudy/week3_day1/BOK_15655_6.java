package BookStudy.week3_day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOK_15655_6 {
    static int N;
    static int M;
    static int[] data;
    static int[] arr;
    static int idx;
    static StringBuffer sb;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        data = new int[N];
        arr = new int[M];
        for(int i=0; i<data.length; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        visited = new boolean[N+1];
        idx = 0;
        sb = new StringBuffer();
        recur(0);
        System.out.println(sb.toString());
    }
    public static void recur(int depth){
        if(depth == M){
            print(arr);
            return;
        }
        visited[idx%(N+1)] = true;
        for(int i=1; i<=N; i++) {
//            if(depth != 0 && arr[depth-1] >= i){
//                continue;
//            }
            if(visited[i]) continue;
            arr[depth] = i;

            recur(depth+1);
        }
        idx++;
    }
    public static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            sb.append(data[arr[i]-1] +" ");
//            System.out.print(arr[i] +" ");
        }
        sb.append("\n");
//        System.out.println(sb);
    }
}
