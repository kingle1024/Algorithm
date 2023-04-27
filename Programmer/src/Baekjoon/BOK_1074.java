package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_1074 {
    static int[][] arr;
    static int N;
    static int r;
    static int c;
    static int count = 0;


    static int nx;
    static int ny;
    static int cnt;

    // 2 3 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);

        arr = new int[N][N];

        find(size, r, c);
        System.out.println(count);

//        dfs();
    }
    private static void find(int size, int r, int c) {
        if(size == 1)
            return;

        if(r < size/2 && c < size/2) {
            find(size/2, r, c);
        }
        else if(r < size/2 && c >= size/2) {
            count += size * size / 4;
            find(size/2, r, c - size/2);
        }
        else if(r >= size/2 && c < size/2) {
            count += (size * size / 4) * 2;
            find(size/2, r - size/2, c);
        }
        else {
            count += (size * size / 4) * 3;
            find(size/2, r - size/2, c - size/2);
        }
    }

    private static void dfs() {
        int[] dx = {0, 0, 1, 0};
        int[] dy = {0, 1, -1, 1};


        for (int i = 0; i < 4; i++) {

        }

    }

}
