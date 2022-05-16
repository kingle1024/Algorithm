import java.util.Random;
import java.util.Scanner;

public class exam07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[로또 당첨 프로그램]\n");

        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int lottoCnt = sc.nextInt();
        int lottoArr[][] = new int[lottoCnt][6];
        int presentLottoArr[] = new int[6];
        Random r = new Random();
        int randomNum;
        for(int i=0; i<lottoCnt; i++){
            System.out.printf("%c\t", 'A'+i);
            for(int j=0; j<6; j++){
                randomNum = r.nextInt(44)+1;
                for(int k=0; k<j; k++){ // 중복 숫자 여부를 구하는 로직. 만약 중복이면 다시 random을 실행
                    if(randomNum == lottoArr[i][k]){
                        while(true){
                            randomNum = r.nextInt(44)+1;
                            if(randomNum != lottoArr[i][k]){
                                break;
                            }
                        }
                    }
                }
                lottoArr[i][j] = randomNum;
                if(j != 5) {
                    System.out.printf("%02d,",lottoArr[i][j]);
                }else{
                    System.out.printf("%02d",lottoArr[i][j]);
                }
            }
            System.out.println();
        }

        // 로또 발표
        System.out.println("\n[로또 발표]");
        System.out.print("\t");
        for (int i = 0; i < presentLottoArr.length; i++) {
            randomNum = r.nextInt(44)+1;
            for(int j=0; j<i; j++){
                if(presentLottoArr[j] == randomNum){
                    while(true){
                        randomNum = r.nextInt(44)+1;
                        if(randomNum != presentLottoArr[j]){
                            break;
                        }
                    }
                }

            }
            presentLottoArr[i] = randomNum;
            if(i != 5) {
                System.out.printf("%02d,",presentLottoArr[i]);
            }else{
                System.out.printf("%02d\n",presentLottoArr[i]);
            }
        }

        // 내 로또 결과
        int cnt[] = new int[lottoCnt];
        for (int k = 0; k < lottoCnt; k++) {
            for(int i=0; i < 6; i++){
                for (int j = 0; j < 6; j++) {
                    if(presentLottoArr[i] == lottoArr[k][j]){
                        cnt[k]++;
                    }
                }
            }
        }

        System.out.println("\n[내 로또 결과]");
        for (int i = 0; i < cnt.length; i++) {
            System.out.printf("%c\t", 'A'+i);
            for (int j = 0; j < 6; j++) {
                if(j != 5) {
                    System.out.printf("%02d,",lottoArr[i][j]);
                }else{
                    System.out.printf("%02d",lottoArr[i][j]);
                }
            }
            System.out.println(" => "+cnt[i]+"개 일치");
        }
    }
}
