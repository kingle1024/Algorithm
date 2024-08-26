package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOK_13301 {

    // 13301
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()) + 1;
        long[] arr = new long[N + 1];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        long result = (arr[N-1] + arr[N]) * 2;
        bw.write(result + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
