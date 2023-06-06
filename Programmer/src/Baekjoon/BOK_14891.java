package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_14891 {
    static String[] g;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = new String[4];
        g[0] = br.readLine();
        g[1] = br.readLine();
        g[2] = br.readLine();
        g[3] = br.readLine();

        // 12시방향부터 시계방향 순서대로 주어진다
        int[][] direct = {{6,2}, {6,2}, {6,2}, {6,2}};
        Gear[] gears = {new Gear(6,2),
                new Gear(6,2),
                new Gear(6,2),
                new Gear(6,2)
        };


        int loop = Integer.parseInt(br.readLine());
        // N S
        for (int i = 0; i < loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearIdx = Integer.parseInt(st.nextToken()) -1;
            int rotate = Integer.parseInt(st.nextToken());

            gearMove(gears, gearIdx, rotate);


        }

    }

    private static void gearMove(Gear[] gears, int gearIdx, int rotate) {
        Gear gear = gears[gearIdx];
        if(gearIdx != 0 && gearIdx != 3) {
            Gear gearLeft = gears[gearIdx - 1];
            Gear gearRight = gears[gearIdx + 1];

            char lLeft = g[gearIdx-1].charAt(gearLeft.left);
            char lRight = g[gearIdx-1].charAt(gearLeft.right);

            char rLeft = g[gearIdx+1].charAt(gearRight.left);
            char rRight = g[gearIdx+1].charAt(gearRight.left);

            char nLeft = g[gearIdx].charAt(gear.left);
            char nRight = g[gearIdx].charAt(gear.right);

            nowGearRotate(gears, gearIdx, rotate);

            if(nLeft != lRight){ // move
                if(rotate == 1){ // 시계
                    rotateRight(gears, gearIdx, gearLeft, lLeft);
                }else{ // 반시계
                    rotateLeft(gears, gearIdx, gearLeft, lLeft);
                }
            }

            if(nRight != rLeft){
                if(rotate == 1){
                    gears[gearIdx +1].right += 1;
                    gears[gearIdx +1].left += 1;
                }else{
                    gears[gearIdx +1].right -= 1;
                    gears[gearIdx +1].left -= 1;
                }
            }

        }
    }

    private static void nowGearRotate(Gear[] gears, int gearIdx, int rotate) {
        if(rotate == 1){
            gears[gearIdx].right -= 1;
            gears[gearIdx].left -= 1;
        }else{
            gears[gearIdx].right += 1;
            gears[gearIdx].left += 1;
        }
    }

    private static void rotateLeft(Gear[] gears, int gearIdx, Gear gearLeft, char lLeft) {
        if(gearIdx -2 > -1){
            char ll_Right = g[gearIdx -2].charAt(gearLeft.right);
            if(lLeft != ll_Right){
                gears[gearIdx -2].right +=1;
                gears[gearIdx -2].left +=1;
            }
        }

        gears[gearIdx -1].right -= 1;
        gears[gearIdx -1].left -=1;
    }

    private static void rotateRight(Gear[] gears, int gearIdx, Gear gearLeft, char lLeft) {
        if(gearIdx -2 > -1){
            char ll_Right = g[gearIdx -2].charAt(gearLeft.right);
            if(lLeft != ll_Right){
                gears[gearIdx -2].right -=1;
                gears[gearIdx -2].left -=1;
            }
        }

        gears[gearIdx -1].right += 1;
        gears[gearIdx -1].left +=1;
    }

    static class Gear{
        int left;
        int right;

        public Gear(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
