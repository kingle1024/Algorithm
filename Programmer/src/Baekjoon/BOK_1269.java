package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOK_1269 {

    // 1269
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int num = Integer.parseInt(st.nextToken());
            aSet.add(num);
        }

        Set<Integer> bSet = new HashSet<>();
        st  = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(st.nextToken());
            bSet.add(num);
        }

        int cnt1 = 0;
        for(int aNum : aSet) {
            if(bSet.contains(aNum)) {
                cnt1++;
            }
        }
        int result1 = bSet.size() - cnt1;

        int cnt2 = 0;
        for(int bNum : bSet) {
            if(aSet.contains(bNum)) {
                cnt2++;
            }
        }
        int result2 = aSet.size() - cnt2;

        bw.write(result1 + result2 + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
