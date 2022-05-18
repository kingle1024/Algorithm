import java.util.Random;
import java.util.Scanner;

public class exam04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[주민등록번호 계산]");

        int yyyy = 0;
        yyyy = getYYYY(yyyy);

        int mm = 0;
        mm = getMM(mm);

        int dd = 0;
        dd = getDD(dd);

        String gender = null;
        gender = getGender(gender);

        int genderNum;
        if(gender.toLowerCase().equals("m")){
            genderNum = 3;
        }else{
            genderNum = 4;
        }
        Random random = new Random();
        System.out.printf("%d%d%d-%d%06d", yyyy, mm, dd, genderNum, random.nextInt(999999));

    }
    public static int getYYYY(int yyyy){
        Scanner sc = new Scanner(System.in);
        String strYYYY = "";
        while(true){
            System.out.print("출생년도를 입력해 주세요.(yyyy):");
            strYYYY = sc.nextLine();
            try{
                yyyy = Integer.parseInt(strYYYY);
                while(true){
                    if(yyyy > 3000 || yyyy < 1500){
                        throw new Exception();
                    }else{
                        break;
                    }
                }
                break;
            }catch(Exception e){
                System.out.println("출생년도는 1500에서 3000 사이의 숫자로 입력해주세요.");
            }
        }
        return yyyy;
    }
    public static int getMM(int mm){
        Scanner sc = new Scanner(System.in);
        String strMM = "";
        while(true){
            System.out.print("출생월을 입력해 주세요.(mm):");
            strMM = sc.nextLine();
            try{
                mm = Integer.parseInt(strMM);
                while(true){
                    if(mm < 1 || mm > 12){
                        throw new Exception();
                    }else{
                        break;
                    }
                }
                break;
            }catch(Exception e){
                System.out.println("출생월은 1월에서 12월 사이로 입력해주세요.");
            }
        }
        return mm;
    }
    public static int getDD(int dd){
        Scanner sc = new Scanner(System.in);
        String strDD = "";
        while(true){
            System.out.print("출생일을 입력해 주세요.(dd):");
            strDD = sc.nextLine();
            try{
                dd = Integer.parseInt(strDD);
                while(true){
                    if(dd < 1 || dd > 31){
                        throw new Exception();
                    }else{
                        break;
                    }
                }
                break;
            }catch(Exception e){
                System.out.println("출생일은 1일에서 31일 사이로 입력해주세요.");
            }
        }
        return dd;
    }
    public static String getGender(String gender){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("성별을 입력해 주세요.(m/f):");
            gender = sc.nextLine();
            if(gender.toLowerCase().equals("m") || gender.toLowerCase().equals("f")){
                break;
            }else{
                System.out.println("잘못 입력하셨습니다. m 혹은 f을 입력해주세요.");
            }
        }
        return gender;
    }
}
