package test;

import java.io.*;
import java.util.StringTokenizer;

public class BOK_15651 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M+1];
        visited = new boolean[N+1];
        recur(1, 0);
        bw.flush();
    }

    public static void recur(int at, int depth) throws IOException {
        if (depth == M) {
            print();
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth+1] = i;
            recur(i+1, depth + 1);
        }

    }
    public static void print() throws IOException {
        for(int i=1; i<=M; i++){
            bw.write(arr[i]+" ");
        }
        bw.write("\n");
    }
}
