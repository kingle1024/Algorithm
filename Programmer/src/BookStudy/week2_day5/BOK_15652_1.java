package BookStudy.week2_day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_15652_1 {
    static boolean visited[];
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // n까지 진행
        m = Integer.parseInt(st.nextToken()); // 자릿수
        arr = new int[m];

        visited = new boolean[n+1];
        recur(0);
    }
    public static void recur(int depth){
        if(depth == m){
            print(arr);
            return;
        }

        for(int i=1; i<=n; i++){
            if(depth != 0){
                if(arr[depth-1] > i) continue;
                arr[depth] = i;
            }else{
                arr[depth] = i;
            }

            recur(depth+1);
        }
    }
    public static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
