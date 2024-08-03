package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOK_14729 {

    // 14729
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double[] arr = new double[9]; // 8 보다 1 더 큰 9로 선언
        for (int i = 0; i < 8; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Arrays.fill(arr, 8, arr.length, 9999);
        Arrays.sort(arr);

        for (int i = 0; i < N-8; i++) {
            double d = Double.parseDouble(br.readLine());

            // 앞에서부터 순회
            for (int j = 0; j < 7; j++) {
                if(arr[j] >= d) {
                    // 한칸씩 뒤로 미룸
                    for (int k = 7; k >= j; k--) {
                        arr[k+1] = arr[k];
                    }
                    arr[j] = d;
                    break;
                }

            }
        }

        // 포맷에 맞게 출력
        for(int i = 0; i < 7; i++) {
            bw.write(String.format("%.3f", arr[i]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
