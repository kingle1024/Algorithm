package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_1010 {
    public static void main(String[] args) throws IOException {
        System.out.println(nCr(29, 13));
        System.out.println(factorial(29));
        System.out.println(factorial(13));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        for(int i=0; i<loop; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(r == n) System.out.println("1");
            else{
                // nCr -> n! / r!(n-r)!
                System.out.println((int)(factorial(n) / (factorial(r) * factorial(n-r))));
//                System.out.println(factorial(n));
//                System.out.println(factorial(r));
//                System.out.println(factorial(n-r));
            }
        }
    }
    public static long factorial(int n){
        long result = 1 ;
        for(int i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }
    static long nCr(int n, int r){
        if( r > n ) return -1;
        if( r == 0 ) return 1;
        if( n == r ) return 1;
        if( n-r<r ) r=n-r;
        long res = 1;
        for(int i=1; i<=r; i++) res = res*(n-i+1)/i;
        return res;
    }
}
