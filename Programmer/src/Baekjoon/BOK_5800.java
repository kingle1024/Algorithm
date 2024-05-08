package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOK_5800 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int loop = Integer.parseInt(br.readLine());
        for (int i = 0; i < loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int loop2 = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < loop2; j++) {
                final int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }
            Collections.sort(list);
            final int size = list.size();
            int maxGaap = -1;
            for (int j = 0; j < size-1; j++) {
                maxGaap = Math.max(maxGaap, list.get(j+1) - list.get(j));
            }
            bw.write("Class " + (i + 1) + "\n");
            bw.write("Max " + list.get(list.size() - 1) + ", Min " + list.get(0) + ", Largest gap " + maxGaap + "\n");
        }

        bw.flush();
        bw.close();
    }

}
