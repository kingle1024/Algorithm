package Baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_14503 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    static int[][] arr;
//    static int[] dHeight = {0, -1, 0, 1};
//    static int[] dWidth = {-1, 0, 1, 0};
    static int[] dHeight = {-1, 0, 1, 0};
    static int[] dWidth = {0, 1, 0, -1};
    static int startArrow;
    static int cnt;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        arr = new int[height][width];

        st = new StringTokenizer(br.readLine());

        int startHeight = Integer.parseInt(st.nextToken());
        int startWidth = Integer.parseInt(st.nextToken());
        startArrow = Integer.parseInt(st.nextToken());

        for(int i=0; i < height; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(startHeight, startWidth);


    }
    // 북, 동, 남, 서
    private static void search(int startCol, int startRow) {
        if(arr[startCol][startRow] == 0){
            cnt++;
            arr[startCol][startRow] = 1;
        }
        Robot robot = new Robot(startCol, startRow, startArrow);

        int rotateCnt = 0;
        while(true){
            System.out.println("x,y = " + robot.posHeight +" " + robot.posWidth +" "+(robot.arrow)%4);

            // 현재 위치를 청소한다.
            if(arr[robot.posHeight][robot.posWidth] == 0){
                arr[robot.posHeight][robot.posWidth] = 1;
                cnt++;
            }

            // 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
            if(robot.canGo()){
                robot.go();
                rotateCnt = 0;
                System.out.println("> 1");
            } else {

                // 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
                // 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
                if(rotateCnt == 4){
                    if(robot.canBack()) {
                        System.out.println("> 2");
                        robot.back();
                    }else{
                        // 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                        System.out.println("> 3");
                        break;
                    }
                }else{
                    System.out.println("> 4");
                    rotateCnt++;
                }
            }
        }

        System.out.println("cnt = " + cnt);
    }

    static class Robot{
        int posHeight;
        int posWidth;
        int arrow;

        public Robot(int nHeight, int posWidth, int arrow) {
            this.posHeight = nHeight;
            this.posWidth = posWidth;
            this.arrow = arrow;
        }

        public boolean canGo(){
            this.arrow += 3;
            int nextHeight = this.posHeight + dHeight[(arrow)%4];
            int nextWidth = this.posWidth + dWidth[(arrow)%4];

            if(arr[nextHeight][nextWidth] == 0){
                return true;
            }else{
                return false;
            }
        }

        public void go() {
            // 회전
            int nextHeight = this.posHeight + dHeight[this.arrow%4];
            int nextWidth = this.posWidth + dWidth[this.arrow%4];
            // 전진
            arr[nextHeight][nextWidth] = 2;

            this.posHeight = nextHeight;
            this.posWidth = nextWidth;

            cnt++;
//            System.out.println("x,y = " + this.posHeight +" " + this.posWidth +" "+(this.arrow)%4);
        }

        public boolean canBack(){
            // 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//            System.out.println("arrow = " + arrow);
            int nextArrow = (arrow+2) % 4;
            int nextPosHeight = this.posHeight + dHeight[nextArrow];
            int nextPosWidth = this.posWidth + dWidth[nextArrow];
//            System.out.println("canBack > "+nextPosHeight+" "+ nextPosWidth+" "+nextArrow);

            if(arr[nextPosHeight][nextPosWidth] == 0 || arr[nextPosHeight][nextPosWidth] == 2){
                return true;
            } else {
                return false;
            }
        }

        public void back() {
            int nextArrow = (arrow) % 4;
            int nextPosHeight = this.posHeight + dHeight[nextArrow];
            int nextPosWidth = this.posWidth + dWidth[nextArrow];
            arr[nextPosHeight][nextPosWidth] = 2;
            arrow += 2;

            this.posWidth = nextPosWidth;
            this.posHeight = nextPosHeight;
        }
    }

}





















