package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOK_1748 {

    // 1748
    public static void main(String[] args) throws IOException {
        process();
    }

    // 1~9      : 1 * 1 * 9
    // 10~99    : 2 * 10 * 9
    // 100~999  : 3 * 100 * 9
    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int plus = 1;
        int digits = 10;
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(i % digits == 0) {
                plus += 1;
                digits*=10;
            }
            cnt += plus;
        }
        bw.write(cnt + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
