package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.StringTokenizer;

public class BOK_1340 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String Month = st.nextToken();
        String date = st.nextToken();
        date = date.substring(0, date.length()-1);
        String yyyy = st.nextToken();
        String[] hhmm = st.nextToken().split(":");
        String hh = hhmm[0];
        String mm = hhmm[1];

        int month = getMonth(Month);
        int yyyyNum = Integer.parseInt(yyyy);
        int dateNum = Integer.parseInt(date);
        int hhNum = Integer.parseInt(hh);
        int mmNum = Integer.parseInt(mm);


        Calendar target = Calendar.getInstance();
        target.set(yyyyNum, month, dateNum, hhNum, mmNum);

        Calendar start = Calendar.getInstance();
        start.set(yyyyNum, Calendar.JANUARY, 1, 0, 0);
        Calendar end = Calendar.getInstance();
        end.set(yyyyNum, Calendar.DECEMBER, 31, 23, 59);


        long son = end.getTimeInMillis() - target.getTimeInMillis();
        long mother = end.getTimeInMillis() - start.getTimeInMillis();

        if(month == Calendar.JANUARY
                && dateNum == 1
                && hhNum == 0
                && mmNum == 0
        ){
            System.out.println("0.0");
        }else{
            double result = (1 - (son / (double)mother)) * 100;
            System.out.println(result);
        }



    }

    private static int getMonth(String month) {
        switch (month){
            case "January":{
                return Calendar.JANUARY;
            }
            case "February":{
                return Calendar.FEBRUARY;
            }
            case "March":{
                return Calendar.MARCH;
            }
            case "April":{
                return Calendar.APRIL;
            }
            case "May":{
                return Calendar.MAY;
            }
            case "June":{
                return Calendar.JUNE;
            }
            case "July":{
                return Calendar.JULY;
            }
            case "August":{
                return Calendar.AUGUST;
            }
            case "September":{
                return Calendar.SEPTEMBER;
            }
            case "October":{
                return Calendar.OCTOBER;
            }
            case "November":{
                return Calendar.NOVEMBER;
            }
            case "December":{
                return Calendar.DECEMBER;
            }
        }
        return -1;
    }
}
