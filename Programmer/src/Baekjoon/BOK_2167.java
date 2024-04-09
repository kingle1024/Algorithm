package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOK_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N+1][M+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M+1 ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        final int loop = Integer.parseInt(br.readLine());
        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            final int fromX = Integer.parseInt(st.nextToken());
            final int fromY = Integer.parseInt(st.nextToken());
            final int toX = Integer.parseInt(st.nextToken());
            final int toY = Integer.parseInt(st.nextToken());
            int result = 0;
            for (int j = fromX; j < toX+1; j++) {
                for (int k = fromY; k < toY+1; k++) {
                    result += arr[j][k];
                }
            }
            System.out.println(result);
        }

    }
}
