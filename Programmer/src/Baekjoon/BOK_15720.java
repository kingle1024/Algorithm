import Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOK_15720 {

    // 15720
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        double totalAmt = 0;
        double disCountAmt = 0;
        int minCnt = Math.min(Math.min(B, C), D);
        int maxCnt = Math.max(Math.max(B, C), D);

        List<Integer> bArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(st.nextToken());
            bArr.add(num);
        }
        List<Integer> cArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            int num = Integer.parseInt(st.nextToken());
            cArr.add(num);
        }
        List<Integer> dArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            int num = Integer.parseInt(st.nextToken());
            dArr.add(num);
        }

        // 계산
        bArr.sort(Collections.reverseOrder());
        cArr.sort(Collections.reverseOrder());
        dArr.sort(Collections.reverseOrder());
        int tempIdx = 0;
        while (tempIdx != minCnt) {
            totalAmt += bArr.get(tempIdx);
            tempIdx++;
        }
        tempIdx = 0;
        while (tempIdx != minCnt) {
            totalAmt += cArr.get(tempIdx);
            tempIdx++;
        }

        tempIdx = 0;
        while (tempIdx != minCnt) {
            totalAmt += dArr.get(tempIdx);
            tempIdx++;
        }
        disCountAmt = totalAmt * 0.9;

        for (int i = minCnt; i < maxCnt; i++) {
            int amt = 0;
            if(bArr.size() > i) {
                amt += bArr.get(i);
            }
            if(cArr.size() > i) {
                amt += cArr.get(i);
            }
            if(dArr.size() > i) {
                amt += dArr.get(i);
            }

            totalAmt += amt;
            disCountAmt += amt;
        }

        bw.write((long)totalAmt + "\n" + (long)disCountAmt);
        bw.flush();
        bw.close();
        br.close();
    }
}
