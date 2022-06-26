package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOK_24416 {
    static int cnt = 0;
    static int fib(int n){
        if(n == 1 || n == 2){
            cnt++;
            return 1;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }
    static int[] f = new int[41];
    static int fCnt = 0;
    static int fibonacci(int n){
        f[1] = 1;
        f[2] = 1;
        for(int i=3; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
            fCnt++;
        }
        return f[n];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fib(N);
        fibonacci(N);
        System.out.println(cnt + " "+fCnt);
    }
}
