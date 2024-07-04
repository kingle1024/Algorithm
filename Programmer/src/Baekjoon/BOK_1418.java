package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOK_1418 {

    // 1418 K세준수
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int num = getPrimeFactors(i, K);
            sum += num;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();

    }

    public static int getPrimeFactors(int number, int limitNum) {
        if(number == 1) return 1;
        int max = -1;

        // 2로 나누기
        while (number % 2 == 0) {
            max = 2;
            number /= 2;
        }

        // 3 이상 홀수로 나누기
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                if(max < i && limitNum >= i) {
                    max = i;
                }
                number /= i;
            }
        }

        // 마지막으로 남은 수가 소수인 경우
        if (number > 2) {
            max = Math.max(max, number);
        }

        if(max != -1 && max <= limitNum) {
            return 1;
        } else {
            return 0;
        }
    }
}
