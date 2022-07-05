package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_1003 {
    static int[][] cnt = new int[100][2];
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[T][2];


        for(int i=0; i<T; i++){
            arr[i] = fibonacci(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[] fibonacci(int n){
        cnt[0] = new int[]{1, 0};
        cnt[1] = new int[]{0, 1};

        for (int i = 2; i <= n; i++) {
            cnt[i][0] = cnt[i-2][0] + cnt[i-1][0];
            cnt[i][1] = cnt[i-2][1] + cnt[i-1][1];
        }
        return cnt[n];
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
