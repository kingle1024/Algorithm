package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOK_4158 {

    // 4158 CD
    public static void main(String[] args) throws IOException {
        process();
    }
    
    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열에 값 넣기
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }

            Map<Long, Boolean> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                long num = Long.parseLong(br.readLine());
                map.putIfAbsent(num, true);
            }

            int result = 0;
            for (int i = 0; i < M; i++) {
                long num = Long.parseLong(br.readLine());
                boolean isOk = map.getOrDefault(num, false);
                if (isOk) {
                    result+=1;
                }
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}
