package Baekjoon

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOK_5648 {

    // 5648
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop = -1;
        int loopCnt = 0;
        List<Long> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startIdx = st.countTokens();

        for (int i = 0; i < startIdx; i++) {
            if(i == 0) {
                loop = Integer.parseInt(st.nextToken());
            } else {
                String reverse = new StringBuilder(st.nextToken()).reverse().toString();
                list.add(Long.parseLong(reverse));
                loopCnt++;
            }
        }

        while (loopCnt != loop) {

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                String reverse = new StringBuilder(st.nextToken()).reverse().toString();
                list.add(Long.parseLong(reverse));
                loopCnt++;
            }
        }

        Collections.sort(list);
        for (Long item : list) {
            bw.write(item + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
