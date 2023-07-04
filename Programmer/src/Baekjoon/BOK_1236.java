package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_1236 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        boolean isX;
        int col = 0;

        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            isX = false;
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 'X'){
                    isX = true;
                    break;
                }
            }
            if(!isX) col++;
        }

        int row = 0;
        for (int i = 0; i < M; i++) {
            isX = false;
            for (int j = 0; j < N; j++) {
                if(arr[j][i] == 'X'){
                    isX = true;
                    break;
                }
            }
            if(!isX) row++;
        }

//        System.out.println("col = " + col);
//        System.out.println("row = " + row);
        System.out.println(Math.max(col, row));
    }
}
