package Baekjoon

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_1817 {

    // 1817
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(N == 0) {
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        int boxTemp = M;
        int boxCnt = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(boxTemp >= input) {
                boxTemp -= input;
            } else {
                boxTemp = M - input;

                if(boxTemp < 0) {
                    break;
                } else {
                    boxCnt++;
                }
            }
        }

        bw.write(boxCnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
