package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_20546 {

    // 20546
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int money = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]arr = new int[14];
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int aCnt;
        int bCnt;
        

        bw.flush();
        bw.close();
        br.close();
    }

}
