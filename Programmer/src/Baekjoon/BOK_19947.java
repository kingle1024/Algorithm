package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_19947 {
    static long result = 0;
    static void solution(long H, long Y) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

//        long H = Long.parseLong(st.nextToken());
//        long Y = Long.parseLong(st.nextToken());
        result = H;
        recursive(Y);
        System.out.println(result);
    }
    public static void recursive(long n){
//        System.out.println(result);
        if(n == 0) return;
        else if(n % 3 == 0) {
            result = (long)(result*1.2);
            n-=3;
            System.out.println("[1] -3");
        }else if(n % 3 == 0){
            result = (long)(result*1.35);
            n-=5;
            System.out.println("[2] -5");
        }else if(n>0 && (n/5 < n/3)){
            result = (long)(result * 1.2);
            n-=3;
            System.out.println("[3] -3");
        }else if(n>0 && (n/5 > n/3)){
            result = (long)(result * 1.35);
            n-=5;
            System.out.println("[4] -5");
        }else if(n > 0){
            result = (long)(result * 1.05);
            n-=1;
            System.out.println("[5] -1");
        }

        recursive(n);
    }
    public static void main(String[] args) throws Exception{
        for(int i=9; i>=1; i--){
            solution(10000, i);
            System.out.println();
        }

    }
}
