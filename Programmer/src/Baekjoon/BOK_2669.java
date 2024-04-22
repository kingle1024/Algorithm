package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        boolean[][] arr = new boolean[101][101];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    arr[j][k] = true;
                }
            }
        }

        int result = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if(arr[j][i]) {
                    result += 1;
                }
            }
        }
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
