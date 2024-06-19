package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_1268 {

    public static void main(String[] args) throws IOException {
        extracted();
    }
    private static void extracted() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열에 값 넣기
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][5];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        //
        int[][] cntArr = new int[N][5];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < 5; x++) {
                int n = arr[y][x];
                for (int i = 0; i < N; i++) {
                    if(n == arr[i][x]) {
                        cntArr[y][x]++;
                    }
                }
            }
        }

        int[] rank = new int[N];
        int max = -1;
        int maxCnt = -1;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                cnt += cntArr[i][j];
            }
            rank[i] = cnt;

            if(max < cnt) {
                max = cnt;
                maxCnt = i;
            }
        }

        bw.write((maxCnt+1) + "");

        bw.flush();
        bw.close();
    }

}
