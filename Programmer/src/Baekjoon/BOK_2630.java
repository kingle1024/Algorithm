package Baekjoon;

import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class BOK_2630 {
    static int inputSize;
    static int[][] arr;
    static int count_0 = 0;
    static int count_1 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputSize = Integer.parseInt(br.readLine());
        arr = new int[inputSize][inputSize];

        // init
        for (int i = 0; i < inputSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < inputSize; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 紐⑤몢 媛숈쑝硫� true, 媛��닔 異붽�
        // �븘�땲硫� �떎�떆 遺꾪븷
        partition(0, 0, inputSize);

        System.out.println(count_0);
        System.out.println(count_1);
    }

    private static void partition(int row, int col, int size) {
        int num = arr[row][col];
        boolean isDifferent = false;
        outer : for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if(num != arr[i][j]) {
                    isDifferent = true;
                    break outer;
                }
            }
        }

        size /= 2;
        if(isDifferent){
            partition(row, col + size, size); // 1
            partition(row, col, size); // 2
            partition(row + size, col, size); // 3
            partition(row + size, col + size, size); // 4
        } else {
            if(num == 0) {
                count_0++;
            } else {
                count_1++;
            }
        }

    }


}
