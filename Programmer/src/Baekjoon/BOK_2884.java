package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hh = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());

        int totalMM = hh*60 + mm;
        if(totalMM -45 < 0){
            totalMM = 24*60 + mm;
            totalMM -= 45;
        }else {
            totalMM -= 45;
        }
//        System.out.println(totalMM);
        int reusltHH = totalMM/60;
        int resultMM = totalMM - (reusltHH * 60);
        resultMM = totalMM%60;
        System.out.println(reusltHH + " " + resultMM);
    }
}
