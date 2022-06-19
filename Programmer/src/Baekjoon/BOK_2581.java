package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOK_2581 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int min = -1;
        int sum = 0;
        boolean check = false;
        for(int i=N; i<=M; i++){
            if(i<2) continue;
            if(sosu(i)){
                if(!check && i > 1){
                    min = i;
                    check = true;
                }
                sum += i;
//                System.out.println(i);
            }
        }
        if(sum != 0) {
            System.out.println(sum);
        }
        System.out.println(min);
    }
    static boolean sosu(int num){
        for(int i=2; i<num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
