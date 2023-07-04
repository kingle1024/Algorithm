package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.StringTokenizer;

public class BOK_1308 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sYear = Integer.parseInt(st.nextToken());
        int sMonth = Integer.parseInt(st.nextToken());
        int sDay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int eYear = Integer.parseInt(st.nextToken());
        int eMonth = Integer.parseInt(st.nextToken());
        int eDay = Integer.parseInt(st.nextToken());

        // 날짜 설정하기
        Calendar cal = Calendar.getInstance();
        // month에 1을 더해야한다.
        cal.set(sYear,  sMonth, sDay);
        long dDay = cal.getTimeInMillis();

        Calendar cal2 = Calendar.getInstance();
        cal2.set(eYear, eMonth, eDay);
        long now = cal2.getTimeInMillis();

        long result = dDay - now;
        long d = Math.abs(result / 1000 / 60 / 60 / 24);

        if(d >= 365242){
            System.out.println("gg");
        }else {
            System.out.println("D" + d);
        }
    }
}
