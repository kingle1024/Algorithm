package ZeroBase.Assignments;

import java.util.Scanner;

public class exam03 {
    public static void main(String[] args) {
        System.out.println("[입장권 계산]");
        Scanner sc = new Scanner(System.in);
        int age = 0; // 나이
        age = getAge(age);

        int time = 0; // 입장시간
        time = getTime(time);

        String nationalMerit = null; // 국가유공자 여부
        nationalMerit = getNationalMerit(nationalMerit);


        String welfareCard = null; // 복지카드 여부
        welfareCard = getWelfareCard(welfareCard);

        int charge = -1; // 입장료

        if(age < 3) {
            // 3세미만이면 무료입장
            charge = 0;
        }else if(nationalMerit.toLowerCase().equals("y") || welfareCard.toLowerCase().equals("y")){
            // 복지카드와 국가유공자의 경우 일반 할인 적용
            charge = 8000;
        }else if(age < 13){
            // 13세미만이면 특별 할인 적용
            charge = 4000;
        }else if(time > 17){
            // 17시이후에 입장하면 특별 할인 적용
            charge = 4000;
        }

        System.out.println("입장료: "+charge);
    }
    public static int getAge(int age){
        Scanner sc = new Scanner(System.in);
        String strAge; // 나이

        while(true) {
            System.out.print("나이를 입력해 주세요.(숫자):");
            strAge = sc.nextLine();
            try{
                age = Integer.parseInt(strAge);
                while(true){
                    if(age < 0 || age > 150){
                        throw new Exception();
                    }else{
                        break;
                    }
                }
                break;
            }catch(Exception e){
                System.out.println("잘못 입력하셨습니다. 0~150 사이의 숫자를 입력해주세요.");
            }
        }
        return age;
    }
    public static int getTime(int time){
        Scanner sc = new Scanner(System.in);
        String strTime = ""; // 입장시간
        while(true) {
            System.out.print("입장시간을 입력해 주세요.(숫자입력):");
            strTime = sc.nextLine();
            try {
                time = Integer.parseInt(strTime);
                while(true){
                    if(time > 24 || time < 0){
                        throw new Exception();
                    }else{
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("잘못 입력하셨습니다. 0~24 사이의 숫자를 입력해주세요.");
            }
        }

        return time;
    }
    public static String getNationalMerit(String nationalMerit){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
            nationalMerit = sc.nextLine();
            if(nationalMerit.toLowerCase().equals("y") || nationalMerit.toLowerCase().equals("n")){
                break;
            }else{
                System.out.println("잘못 입력하셨습니다. y 혹은 n을 입력해주세요.");
            }
        }

        return nationalMerit;
    }
    public static String getWelfareCard(String welfareCard){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
            welfareCard = sc.nextLine();
            if(welfareCard.toLowerCase().equals("y") || welfareCard.toLowerCase().equals("n")){
                break;
            }else{
                System.out.println("잘못 입력하셨습니다. y 혹은 n을 입력해주세요.");
            }
        }
        return welfareCard;
    }
}
