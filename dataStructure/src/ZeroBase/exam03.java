public class exam03{
    public static void main(String[] args) {
        System.out.println("[입장권 계산]");
        Scanner sc = new Scanner(System.in);

        int age; // 나이
        System.out.print("나이를 입력해 주세요.(숫자):");
        age = sc.nextInt(); // 나이
        System.out.print("입장시간을 입력해 주세요.(숫자입력):");
        int time = sc.nextInt(); // 입장시간
        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        String nationalMerit = sc.next();
        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        String welfareCard = sc.next();
        int charge = -1; // 입장료

        if(age < 3) {
            // 3세미만이면 무료입장
            charge = 0;
        }else if(nationalMerit.equals("y") || welfareCard.equals("y")){
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
}