package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOK_2798 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/2798

       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int M = sc.nextInt();
       int arr[] = new int[N];
       int temp = 0;
       int max = 0;
       boolean check = false;
       for(int i=0; i<N; i++){
           arr[i] = sc.nextInt();
       }
       for(int i=0; i<arr.length; i++){
           for(int j=i+1; j<arr.length; j++){
               for(int k=j+1; k<arr.length; k++){
                   temp = arr[i] + arr[j] + arr[k];
                   if(temp == M) {
                       max = temp;
                       check = true;
                       break;
                   }else if(temp > max && temp < M){
                       max = temp;
                   }
               }
               if(check) break;
           }
           if(check) break;
       }
       System.out.println(max);
    }
}
