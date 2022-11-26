package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_1018 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    static int[][] arr;
    static char[][] map;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= N-8; i++){
            for (int j = 0; j <= M-8; j++) {
                int search = search(i, j);
//                System.out.println(search);
                min = Math.min(min, search);
            }
        }

        System.out.println(Math.min(min, 64 - min));
    }

    private static int search(int startCol, int startRow) {
        int blackCnt = 0;
        int whiteCnt = 0;
        for (int i = 0; i < 8; i++) {
            int col = i + startCol;
            for (int j = 0; j < 8; j++) {
                int row = j + startRow;
                if(i % 2 == 0){ // 짝수줄
                    if(j % 2 == 0 && map[col][row] != 'B'){
                        blackCnt++;
                    }else if(j % 2 == 1 && map[col][row] != 'W'){
                        blackCnt++;
                    }
                }else{ // 홀수줄
                    if(j % 2 == 0 && map[col][row] != 'W'){
                        blackCnt++;
                    }else if(j % 2 == 1 && map[col][row] != 'B'){
                        blackCnt++;
                    }
                }
            }

            // BW BW BW BW
            // WB WB WB WB

            for (int j = 0; j < 8; j++) {
                int row = j + startRow;
                if(i % 2 == 0){ // 짝수줄
                    if(j % 2 == 0 && map[col][row] != 'W'){
                        whiteCnt++;
                    }else if(j % 2 == 1 && map[col][row] != 'B'){
                        whiteCnt++;
                    }
                }else{ // 홀수줄
                    if(j % 2 == 0 && map[col][row] != 'B'){
                        whiteCnt++;
                    }else if(j % 2 == 1 && map[col][row] != 'W'){
                        whiteCnt++;
                    }
                }
            }
        }
        return Math.min(whiteCnt, blackCnt);
    }

}
