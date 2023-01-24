package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long total = Integer.parseInt(br.readLine());
        int loop = Integer.parseInt(br.readLine());
        long sum = 0;
        for (int i = 0; i < loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            sum += a*b;
        }

        if(total == sum){
            System.out.println("YES");
        }else{
            System.out.println("No");
        }
    }
}
