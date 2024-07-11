package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_10709 {

    // 10709 기상캐스터
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int H = Integer.parseInt(st.nextToken());
        final int W = Integer.parseInt(st.nextToken());

        for (int i = 0; i < H; i++) {
            int idx = 1;
            String weather = br.readLine();
            boolean isStart = false;
            for (int j = 0; j < W; j++) {
                if(weather.charAt(j) == 'c') {
                    bw.write("0 ");
                    idx = 1;
                    isStart = true;
                } else {
                    if(isStart) {
                        bw.write((idx++) + " ");
                    } else {
                        bw.write("-1 ");
                    }
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
