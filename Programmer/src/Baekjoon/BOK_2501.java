package Baekjoon;

import java.util.Scanner;

// 브루포스 - 약수 구하기
public class BOK_2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int cnt = 0;
        int result = -1;
        for(int i=1; i<=N; i++){
            if(N % i == 0){
                cnt++;
            }
            if(cnt == M){
                result = i;
                break;
            }
        }

        if(cnt == M){
            System.out.println(result);
        }else{
            System.out.println("0");
        }

    }
}
