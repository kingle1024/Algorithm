package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOK_16234 {
    static boolean[][] visited;
    static int N;
    static int L;
    static int R;
    static int[][] arr;
    static int areaCnt;
    static int visitedCnt;
    static boolean countMove;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        areaCnt = N*N;
        countMove = false;

        insertArr(br);

        do {
            visited = new boolean[N][N];
            countMove = false;
//            sum = 0;
            visitedCnt = 0;

            Outer:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    visited[i][j] = true;
                    visitedCnt++;
                    bfs(i, j);

                    if (visitedCnt == areaCnt) {
                        if (countMove) result++;
                        break Outer;
                    }
                }
            }

//            System.out.println(sum +" " + arr);
        } while (countMove);
//        System.out.println(sum +" " + arr + " "+ result +" "+visitedCnt +" "+areaCnt);
        System.out.println(result);
    }
    static void bfs(int i, int j){
        int sum = 0;
        int[] dHeight = {1, -1, 0, 0};
        int[] dWidth = {0, 0, -1, 1};

        Queue<People> queue = new ArrayDeque<>();
        queue.add(new People(i, j));
        boolean isOpen = false;
        Queue<People> visitQueue = new ArrayDeque<>();

        while(!queue.isEmpty()) {
            People poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nHeight = poll.height + dHeight[k];
                int nWidth = poll.width + dWidth[k];

                if (valid(poll, nHeight, nWidth)) continue;

                visitedCnt++;
                visited[nHeight][nWidth] = true;
                sum += arr[nHeight][nWidth];
                queue.add(new People(nHeight, nWidth));
                visitQueue.add(new People(nHeight, nWidth));
                countMove = true;
                isOpen = true;
            }
        }
        if(isOpen){
            sum += arr[i][j];
            visitQueue.add(new People(i, j));
            int div = sum / visitQueue.size();
            while(!visitQueue.isEmpty()){
                People poll = visitQueue.poll();
                arr[poll.height][poll.width] = div;
            }
        }
    }

    private static boolean valid(People poll, int nHeight, int nWidth) {
        if(nHeight < 0 || nWidth < 0 || nHeight >= N || nWidth >= N) return true;
        if(visited[nHeight][nWidth]) return true;
        int nowArea = arr[poll.height][poll.width];
        int nextArea = arr[nHeight][nWidth];
        int area = Math.abs(nowArea - nextArea);
        return area < L || area > R;
    }

    static class People{
        int height;
        int width;

        public People(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }


    private static void insertArr(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
