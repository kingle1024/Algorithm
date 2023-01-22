package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            long result = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            for (int j = 0; j < b; j++) {
                result = (result * a) % 10;
            }
            if(result == 0) sb.append("10").append("\n");
            else sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
