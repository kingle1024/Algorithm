package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOK_9625 {
    // 9625 BABBA
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());

        Long[] A = new Long[46];
        Long[] B = new Long[46];

        A[1] = 0L; B[1] = 1L;
        A[2] = 1L; B[2] = 1L;
        A[3] = 1L; B[3] = 2L;

        for (int i = 4; i <= K; i++) {
            A[i] = A[i-2] + A[i-1];
            B[i] = B[i-2] + B[i-1];
        }

        long result1 = A[K];
        long result2 = B[K];

        bw.write(result1 + " " + result2);
        bw.flush();
        bw.close();
    }
}
