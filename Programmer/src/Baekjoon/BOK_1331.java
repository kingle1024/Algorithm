package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_1331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean invalid = false;
        String[] input = new String[37];
        int[][] arr = new int[7][7];
        for (int i = 1; i < 37; i++) {
            input[i] = br.readLine();
        }

        int nx = -1;
        int ny = -1;
        int sx = -1;
        int sy = -1;

        for (int i = 1; i < 37; i++) {
            String s = input[i];
            int col = s.charAt(0) - 64;
            int row = s.charAt(1) - 48;
            if(arr[col][row] != 1)
                arr[col][row] = 1;
            else{
                invalid = true;
                break;
            }
            if(i == 1){
                sx = col;
                sy = row;
                nx = col;
                ny = row;
                continue;
            }

            // x방향으로1 y방향으로2를 이동 or x방향으로2 y방향으로1를 이동
            if(Math.abs(nx - col) == 1 && Math.abs(ny - row) == 2
                    || Math.abs(nx - col) == 2 && Math.abs(ny - row) == 1){
                nx = col;
                ny = row;
            }else{
                invalid = true;
                break;
            }

            if(i == 36){
                if(Math.abs(nx - sx) == 1 && Math.abs(ny - sy) == 2
                        || Math.abs(nx - sx) == 2 && Math.abs(ny - sy) == 1){
                }else{
                    invalid = true;
                    break;
                }
            }
        }

        if(invalid){
            System.out.println("Invalid");
        }else{
            System.out.println("Valid");
        }
    }
}
