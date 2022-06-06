package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOK_2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int arr[] = new int [num];
        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int max = 0;

        for(int i=0; i<num; i++){
            if( max < arr[i] * (num - i)) {
                max = arr[i] * (num - i);
            }
        }
        System.out.println(max);
        /*
        10 * 4
        15 * 3
         */
    }
}
