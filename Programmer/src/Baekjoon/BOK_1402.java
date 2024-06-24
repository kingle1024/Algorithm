package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOK_1402 {
    public static void main(String[] args) throws IOException {
        process();
    }
    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열에 값 넣기
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            br.readLine();
        }
        for (int i = 0; i < N; i++) {
            bw.write("yes\n");
        }

        bw.flush();
        bw.close();
    }
}
