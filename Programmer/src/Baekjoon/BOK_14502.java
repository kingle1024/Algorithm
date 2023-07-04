package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOK_14502 {
    static int[][] arr;
    static boolean[][] visited;
    static boolean copyVisited[][];
    static Queue<Pair> virus;
    private static Queue<Pair> bfsQue = new ArrayDeque<>();
    static int height;
    static int width;
    static int max;

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        arr = new int[height][width];
        copyVisited = new boolean[height][width];
        virus = new LinkedList<>();
        int zeroCnt = 0;
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;

                if(num == 2){
                    virus.add(new Pair(i,j));
                    copyVisited[i][j] = true;
                }else if(num == 0) ++zeroCnt;
            }
        }
        zeroCnt -= 3;


        // ptr3 => 6, i=2, j=0
        // ptr3 => 7, i=2, j=1

        for (int ptr1 = 0; ptr1 < height*width; ptr1++) {
            int iterSize = 0;
            visited = copyVisited;
            int row1 = ptr1/width;
            int col1 = ptr1%width;
            if (arr[row1][col1] != 0) continue;
            arr[row1][col1] = 1;
            for (int ptr2 = ptr1+1; ptr2 < height*width; ptr2++) {
                int row2 = ptr2/width;
                int col2 = ptr2%width;
                if(arr[row2][col2] != 0) continue;
                arr[row2][col2] = 1;
                for (int ptr3 = ptr2+1; ptr3 < height*width; ptr3++) {
                    int i = ptr3/width;
                    int j = ptr3%width;
                    if(arr[i][j] != 0) continue;

                    arr[i][j] = 1;
                    int temp_zeroCnt = zeroCnt;
                    int virusCnt = bfs();
//                    System.out.println("visited + \" \" +arr = " + visited + " " +arr);
                    int result = temp_zeroCnt - virusCnt;
                    max = Math.max(max, result);

//                    System.out.println("result = " + result +" / "+ "max = "+max);
                    // 0갯수 - 바이러스갯수 = 최대 영역
//                    System.out.println("max = " + max);
                    arr[i][j] = 0;
                }
                arr[row2][col2] = 0;
            }
            arr[row1][col1] = 0;
//            System.out.println("visited + \" \" +arr = " + visited + " " +arr);
        }
        System.out.println(max);

//        System.out.println(bfs());
//        System.out.println(max+ " " + visited);
    }

    private static int bfs() {
        bfsQue.clear();
        for (int i = 0; i < height; i++) {
            Arrays.fill(visited[i], false);
        }
        int[]dx = {-1, 1, 0, 0};
        int[]dy = {0, 0, -1, 1};
        int virusCnt = 0;

        bfsQue.addAll(virus);

        while (!bfsQue.isEmpty()){
            Pair p = bfsQue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= height || ny >= width || nx < 0 || ny < 0) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    bfsQue.add(new Pair(nx, ny));
                    ++virusCnt;
                }
//                System.out.println(nx+ " " +ny);
            }
//            result = p.cnt;
        }

        return virusCnt;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

