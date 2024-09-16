package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOK_1302 {

    // 1302
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int topCnt = 0;
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int cnt = map.getOrDefault(input, 0) + 1;
            map.put(input, cnt);
            if(topCnt < cnt) {
                topCnt = cnt;
            }
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == topCnt) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        
        bw.write(result.get(0));
        bw.flush();
        bw.close();
        br.close();
    }
}
