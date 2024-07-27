package Baekjoon

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_3135 {

    // 3135
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int minCnt = Math.abs(A-B);
        boolean isSelect = false;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int distance = Math.abs(B-num);
            if(minCnt > distance) {
                minCnt = distance;
                isSelect = true;
            }
        }

        if(isSelect) {
            minCnt++;
        }

        bw.write(minCnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
