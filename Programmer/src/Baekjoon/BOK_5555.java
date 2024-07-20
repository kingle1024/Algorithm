package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOK_5555 {

    // 5555
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int resultCnt = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            // 문장이 그대로 존재하는 경우
            if(input.contains(line)) {
                resultCnt++;
                continue;
            }

            // 문장이 동그랗게 원형으로 존재하는 경우
            StringBuilder sb = new StringBuilder(input);
            for (int j = 0; j < input.length(); j++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                String s = sb.toString();
                if(s.contains(line)) {
                    resultCnt++;
                    break;
                }
            }
        }

        bw.write(resultCnt + " ");
        bw.flush();
        bw.close();
    }
}
