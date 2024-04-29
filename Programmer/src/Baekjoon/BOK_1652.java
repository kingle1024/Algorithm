package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOK_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        if(n == 1) {
            bw.write("0 0\n");
            bw.flush();
            bw.close();
            return;
        }

        int resultRowCnt = 0;
        int resultColCnt = 0;

        for (int i = 0; i < n; i++) {
            boolean isRow = false;
            boolean isCol = false;
            for (int j = 0; j < n-1; j++) {
                if (arr[i][j] == '.' && arr[i][j+1] == '.') {
                    if(!isRow) {
                        resultRowCnt += 1;
                        isRow = true;
                    }
                } else {
                    isRow = false;
                }

                if (arr[j][i] == '.' && arr[j+1][i] == '.') {
                    if(!isCol) {
                        resultColCnt += 1;
                        isCol = true;
                    }
                } else {
                    isCol = false;
                }
            }
        }
        // a[0][0] a[1][0]
        // a[0][1] a[1][1]
        bw.write(resultRowCnt + " " + resultColCnt + "\n");

        bw.flush();
        bw.close();
    }
}
