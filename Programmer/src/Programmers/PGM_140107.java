package Programmers

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PGM_140107 {

    //
    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = 3;
        int d = 7;
        int startX = 0;
        int startY = 0;
        long answer = 1;
        while(true) {
            // 체크
            if(startX >= d) {
                break;
            }
            if (Math.pow(startX, 2) + Math.pow(startY, 2) > Math.pow(d, 2)) {
                startY = 0;
                startX += k;
                continue;
            }

            // 증가
            int plus = startY + k;
            if(plus > d || startX != 0 && plus == d) {
                startX += k;
                startY = 0;
            } else {
                startY = plus;
            }
            System.out.println(startX + " " + startY);
            answer++;
        }


        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
