package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dice1 = Integer.parseInt(st.nextToken());
        int dice2 = Integer.parseInt(st.nextToken());
        int dice3 = Integer.parseInt(st.nextToken());
        int result;
        if(dice1 == dice2 && dice2 == dice3) {
            // 모두 같을때
            result = 10000 + (dice1 * 1000);
//            System.out.println("1");
        }else if(dice1 == dice2 || dice1 == dice3) {
            // 2개만 같을때
            result = 1000 + (dice1 * 100);
//            System.out.println("2");
        }else if(dice2 == dice3) {
            result = 1000 + (dice2 * 100);
//            System.out.println("2-1");
        }else{

//            System.out.println("3");
            int max;
            max = Math.max(Math.max(dice1, dice2), dice3);
            result = max * 100;
        }
        System.out.println(result);
    }
}
