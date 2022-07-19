package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_2231 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int numberLength = N.length();
        int numberN = Integer.parseInt(N);
        boolean check = false;
        int result = 0;
        int idx = numberN - (numberLength * 9);
        if(idx < 2){
            idx = 1;
        }

        for(int i=idx; i<numberN; i++){
            if(dv(String.valueOf(i), N) == 1){
                check = true;
                result = i;
                break;
            }
        }
        if(check){
            System.out.println(result);
        }else{
            System.out.println("0");
        }
    }
    public static int dv(String N, String origin){
        int sum = 0;
        for(int i=0; i<N.length(); i++){
            sum += Integer.parseInt(String.valueOf(N.charAt(i)));
        }
        sum += Integer.parseInt(N);
        String result = String.valueOf(sum);
        if(result.equals(origin)){
            return 1;
        }else{
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
