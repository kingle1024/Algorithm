import java.util.Random;
import java.util.Scanner;

public class exam04{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        int yyyy = sc.nextInt();
        System.out.print("출생월을 입력해 주세요.(mm):");
        int mm = sc.nextInt();
        System.out.print("출생일을 입력해 주세요.(dd):");
        int dd = sc.nextInt();
        System.out.print("성별을 입력해 주세요.(m/f):");
        String gender = sc.next();
        int genderNum;
        if(gender.equals("m")){
            genderNum = 3;
        }else{
            genderNum = 4;
        }
        Random random = new Random();
        System.out.printf("%d%d%d-%d%06d", yyyy, mm, dd, genderNum, random.nextInt(999999));

    }
}