package Baekjoon;

import java.util.Scanner;

public class BOK_2530 {
    public static void main(String[] args) {
        solution();
    }
    static void solution(){
        Scanner sc = new Scanner(System.in);
        int hh = sc.nextInt();
        int mm = sc.nextInt();
        int ss = sc.nextInt();
        int time = sc.nextInt();

        while(true){
            // 탈출
            if(time <= 0){
                break;
            }

            if(time / 3600 > 0){
                int hhT = time/3600;
                time = time - (3600 * hhT);
                hh += hhT;
            }else if(time / 60 > 0){
                int mmT = time/60;
                time = time - (60 * mmT);
                mm += mmT;
            }else{
                ss += time;
                time = 0;
            }
        }

        if(ss > 59){
            mm++;
            ss = ss-60;
        }
        if(mm > 59){
            hh++;
            mm = mm-60;
        }
        if(hh > 23){
            while(true) {
                if(hh < 24) break;
                hh = hh - 24;
            }
        }
        System.out.println(hh +" " +mm+" "+ss);
    }
}
