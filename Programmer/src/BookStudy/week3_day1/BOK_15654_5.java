package BookStudy.week3_day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOK_15654_5 {
    static boolean visited[];
    static int n;
    static int m;
    static int[] arr;
    static int[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // n까지 진행
        m = Integer.parseInt(st.nextToken()); // 자릿수
        arr = new int[m];
        data = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        visited = new boolean[n+1];

        recur(0);
    }
    public static void recur(int depth){
        if(depth == m){
            print(arr);
            return;
        }

        for(int i=1; i<=n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            recur(depth+1);
            visited[i] = false;
        }
    }
    public static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(data[arr[i]-1]+" ");
//            System.out.print(data[arr[i]]+" ");
//            System.out.print(arr[i]+" ");
        }

        System.out.println();
    }
}
