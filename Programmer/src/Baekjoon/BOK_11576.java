package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_11576 {
    // 11576 Base Conversion
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());

        // 10진수로 치환
        long decimalNumber = getAtoDecimal(m, arr, st, A);
        // 10진수를 B넘버로 치환
        StringBuilder result = getToBNumber(decimalNumber, B);

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    private static StringBuilder getToBNumber(long decimalNumber, long B) {
        StringBuilder result = new StringBuilder();
        while(decimalNumber > 0) {
            long remainder = decimalNumber % B;
            result.insert(0, remainder +" ");
            decimalNumber /= B;
        }
        return result;
    }

    private static long getAtoDecimal(int m, int[] arr, StringTokenizer st, long A) {
        long decimalNumber = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            double pow = Math.pow(A, m - i -1);
            double v = arr[i] * pow;
            decimalNumber += (long)v;
        }
        return decimalNumber;
    }
}
