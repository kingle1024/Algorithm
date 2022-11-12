package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex01 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M+1];
        visited = new boolean[N+1];
        recur(1, 0);
    }

    public static void recur(int at, int depth) {
        if (depth == M) {
            print();

            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth+1] = i;

            recur(i+1, depth + 1);
        }

    }
    public static void print(){
        for(int i=1; i<=M; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
}
