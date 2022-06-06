package ZeroBase.Assignments;

import java.time.LocalDate;
import java.util.Scanner;

public class exam05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int yyyy = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int mm = sc.nextInt();

        System.out.printf("[%d년 %02d월]\n", yyyy, mm);
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", "일", "월", "화", "수", "목", "금", "토");

        LocalDate date = LocalDate.of(yyyy, mm, 1);
        String startDateOfWeek = String.valueOf(date.getDayOfWeek());

        int mmDay = -1;
        mmDay = getLeapYear(yyyy, mm, mmDay);

        // 날짜 형식 맞추기 Tab 입력
        for(int i=0; i < getStartDateOfWeek(startDateOfWeek); i++){
            System.out.printf("\t");
        }
        // 날짜(dd) 출력
        for(int i = 1; i<=mmDay; i++){
            if((i+getStartDateOfWeek(startDateOfWeek)) %7 == 0) System.out.printf("%02d\t\n", i);
            else{
                System.out.printf("%02d\t", i);
            }
        }
    }
    public static int getLeapYear(int yyyy, int mm, int mmDay){
        if(mm == 2){
            if(yyyy %4 == 0){ // 윤년 계산
                if(yyyy %400 == 0){
                    mmDay = 29;
                }else if(yyyy %100 == 0){
                    mmDay = 28;
                }else{
                    mmDay = 29;
                }
            }else{
                mmDay = 28;
            }
        }else if(mm %2 == 0){
            mmDay = 30;
        }else{
            mmDay = 31;
        }
        return mmDay;
    }

    public static int getStartDateOfWeek(String startDateOfWeek){
        // 시작 날짜를 구하는 메소드
        int num = -1;
        switch (startDateOfWeek){
            case "SUNDAY":{
                num = 0;
                break;
            }
            case "MONDAY":{
                num = 1;
                break;
            }
            case "TUESDAY":{
                num = 2;
                break;
            }
            case "WEDNESDAY":{
                num = 3;
                break;
            }
            case "THURSDAY":{
                num = 4;
                break;
            }
            case "FRIDAY":{
                num = 5;
                break;
            }
            case "SATURDAY":{
                num = 6;
                break;
            }
        }
        return num;
    }
}
