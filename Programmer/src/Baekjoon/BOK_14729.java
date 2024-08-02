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
        double[] arr = new double[7];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(arr);

        // 2 4 5 6 7 8 9
        for (int i = 0; i < N-7; i++) {
            double d = Double.parseDouble(br.readLine());
            for (int j = 7; j >= 0; j--) {
                if(arr[j] < d) {

                }
            }
        }

        for (int i = 0; i < N; i++) {
            double d = Double.parseDouble(br.readLine());
            for (int j = 0; j < 8; j++) {
                if(arr[j] == null) {
                    arr[j] = d;
                    break;
                } else if(arr[j] > d) {
                    if(arr[j+1] == null) {
                        arr[j+1] = arr[j];
                        arr[j] = d;
                    } else {
                        double temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = d;
                        arr[j + 2] = temp;
                    }
                    break;
                }
            }
        }

        for(int i = 0; i < 7; i++) {
            bw.write(String.format("%.3f", arr[i]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
