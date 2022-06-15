package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class BOK_7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][]arr = new int[num][2];
        int[] rank = new int[num];
        for(int i=0; i<num; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for(int i=0; i<arr.length; i++){
            int cnt = 1;
            for(int j=0; j<arr.length; j++){
                if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]){
                    cnt++;
                }
            }
            rank[i] = cnt;
        }

        for (int i = 0; i < num; i++) {
            System.out.print(rank[i] +" ");
        }

    }
}
