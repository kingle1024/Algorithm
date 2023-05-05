package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long result = 1;
        int cnt = 0;

        int cnt_of_2 = 0;
        int cnt_of_5 = 0;

        // factorial 진행과정 중에서 2와 5의 곱의 개수를 파악한다.
        for(int i=1; i<=num; i++) {
            int target = i;

            // 소인수 분해하며 2의 개수를 파악한다.
            while((target % 2 == 0)) {
                cnt_of_2++;
                target = target / 2;
            }

            // 소인수 분해하여 5의 개수를 파악한다.
            while((target % 5 == 0)) {
                cnt_of_5++;
                target = target / 5;
            }
        }

        System.out.println(Math.min(cnt_of_2, cnt_of_5));
    }
}
