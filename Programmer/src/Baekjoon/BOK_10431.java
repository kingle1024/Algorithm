package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_10431 {
    
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        final int ARR_LENGTH = 21;
        int[] arr = new int[ARR_LENGTH];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < ARR_LENGTH; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int startIdx = 1;
            int searchIdx = 2;
            while(true) {
                if(arr[searchIdx] > arr[startIdx]) {
                    int temp;
                    temp = arr[startIdx];
                    arr[startIdx] = arr[searchIdx-1];
                    arr[searchIdx-1] = temp;


                }

            }
        }


        bw.flush();
        bw.close();
    }
}
