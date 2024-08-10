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
        int[] arr = new int[15];
        int aMoney = money;
        int bMoney = money;
        int aCnt = 0;
        int bCnt = 0;
        int upCnt = 0;
        int downCnt = 0;

        for (int i = 1; i <= 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(aMoney >= arr[i]) {
                int i1 = aMoney / arr[i];
                aCnt += i1;
                aMoney = aMoney - (i1 * arr[i]);
            }

            if(i == 1) {
                continue;
            }

            if(arr[i-1] < arr[i]) { // 상승
                upCnt++;
                downCnt = 0;
                if(upCnt >= 3 && bCnt != 0) {
                    bMoney = arr[i] * bCnt; // 전량매도
                    bCnt = 0;
                }
            } else if(arr[i-1] == arr[i]) {
                // upCnt = 0;
                // downCnt = 0;
                // 아무일도 일어나지 않음
            } else { // 하락
                downCnt++;
                upCnt = 0;
                if(downCnt >= 3) {
                    int i2 = bMoney / arr[i];
                    bCnt += i2;
                    bMoney = bMoney - (i2 * arr[i]);
                }
            }
        }

        long aResult = aMoney + (long)aCnt *arr[14];
        long bResult = bMoney + (long)bCnt *arr[14];
        if(aResult > bResult) {
            bw.write("BNP");
        } else if(aResult < bResult) {
            bw.write("TIMING");
        } else {
            bw.write("SAMESAME");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
