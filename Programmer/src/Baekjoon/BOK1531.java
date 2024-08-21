package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK1531 {

    // 1531
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[101][101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int mosaic = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int xStart = Integer.parseInt(st.nextToken());
            int yStart = Integer.parseInt(st.nextToken());
            int xEnd = Integer.parseInt(st.nextToken());
            int yEnd = Integer.parseInt(st.nextToken());

            for (int j = xStart; j <= xEnd; j++) {
                for (int k = yStart; k <= yEnd; k++) {
                    arr[j][k]++;
                }
            }
        }

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if(arr[i][j] > M) {
                    mosaic++;
                }
            }
        }

        bw.write(mosaic + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
