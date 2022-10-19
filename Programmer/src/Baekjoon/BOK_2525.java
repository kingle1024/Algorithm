package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_2525 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hh = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int timeTaken = Integer.parseInt(st.nextToken());

        int totalMM = (hh * 60) + mm + timeTaken;
        if(totalMM >= 24 * 60){
            totalMM -= 24 * 60;
        }
        int resultHH = totalMM / 60;
        int resultMM = totalMM - (resultHH * 60);
        System.out.println(resultHH +" " + resultMM);

    }
}
