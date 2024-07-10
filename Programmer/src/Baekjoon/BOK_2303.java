package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_2303 {

    // 2303 숫자 게임
    public static void main(String[] args) throws IOException {
        process();
    }

    static int[] arr = new int[5];
    static int tempValue = -1;
    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int maxUserIndex = -1;
        int maxUserValue = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            recursive(0, 1, 2);

            if(maxUserValue <= tempValue) {
                maxUserValue = tempValue;
                maxUserIndex = i+1;
            }
            tempValue = 0;
        }

        bw.write(maxUserIndex + "");
        bw.flush();
        bw.close();
    }

    private static void recursive(int i, int i1, int i2) {
        int sum = (arr[i] + arr[i1] + arr[i2]) % 10;
        tempValue = Math.max(sum, tempValue);

        if(i2 + 1 < 5) {
            recursive(i, i1, i2+1);
        } else if(i+1 < i1) {
            recursive(i+1, i1, i2);
        } else if(i1 + 1 < i2) {
            recursive(i, i1 + 1, i2);
        }
    }
}
