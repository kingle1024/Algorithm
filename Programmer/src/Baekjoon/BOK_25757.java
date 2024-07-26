package Baekjoon

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOK_25757 {

    // 25757
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        switch (game) {
            case "Y": {
                bw.write(set.size() + "");
                break;
            }
            case "F": {
                bw.write(set.size()/2 + "");
                break;
            }
            case "O": {
                bw.write(set.size()/3 + "");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
