package Baekjoon;

import java.util.Scanner;

public class BOK_5596 {
    public static void main(String[] args) {
        solution();
    }
    static void solution(){
        Scanner sc = new Scanner(System.in);
        int resultA = 0;
        int resultB = 0;
        int temp = 0;
        for(int i=0; i<8; i++){
            temp += sc.nextInt();
            if(i==3){
                resultA = temp;
                temp = 0;
            }else if(i==7){
                resultB = temp;
                temp = 0;
            }
        }
        int result = 0;
        if(resultA > resultB){
            result = resultA;
        }else{
            result = resultB;
        }
        System.out.println(result);
    }
}
