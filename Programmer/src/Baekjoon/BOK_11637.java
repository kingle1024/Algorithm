package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BOK_11637 {

    // 11637
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> l = new ArrayList<>();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(br.readLine());
                l.add(num);
                sum += num;
            }
            List<Integer> origin = new ArrayList<>(l);
            Collections.sort(l);
            if(Objects.equals(l.get(l.size() - 1), l.get(l.size() - 2))) {
                bw.write("no winner\n");
            } else {
                // 과반수인 경우
                if(l.get(l.size()-1) > sum / 2) {

                    for(int j = 0; j < l.size(); j++) {
                        if(Objects.equals(origin.get(j), l.get(l.size() - 1))) {
                            bw.write("majority winner " + (j+1) + "\n");
                            break;
                        }
                    }
                } else {
                    for(int j = 0; j < l.size(); j++) {
                        if(Objects.equals(origin.get(j), l.get(l.size() - 1))) {
                            bw.write("minority winner " + (j+1) + "\n");
                            break;
                        }
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
