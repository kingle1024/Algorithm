package Baekjoon;

import java.util.Scanner;

public class BOK_1075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = -1;

        String ten = String.valueOf(N);
        ten = ten.charAt(ten.length()-2)+"";

        int tenNum = Integer.parseInt(ten);
        int one = N%10;

        int nTemp = N - (10*tenNum) - one;

        for(int i=0; i<100; i++){
            if((nTemp+i) % M == 0){
                result = nTemp+i;
                break;
            }
        }
//        System.out.println(result);
        if(result-nTemp < 10){
            System.out.println("0"+(result-nTemp));
        }else{
            System.out.println(result-nTemp);
        }
    }
}
