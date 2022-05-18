import java.util.*;

public class exam07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int lottoCnt = sc.nextInt();
        int presentLottoArr[] = new int[6];
        int randomNum;

        HashSet presentNum = new HashSet();
        presentNum = getPresentNum(presentNum);

        LinkedList presentList = new LinkedList(presentNum);
        Collections.sort(presentList);

        LinkedList<LinkedList> lottoArr = new LinkedList<>();

        // 로또 번호
        getLottoNum(lottoCnt, lottoArr);

        // 로또 발표
        getLottoPresent(presentList);

        // 로또 결과
        getLottoResult(lottoArr, lottoCnt, presentList);

    }
    public static HashSet getPresentNum(HashSet presentNum){
        // 로또 발표 번호 구하는 메소드
        Random r = new Random();
        while(true){
            presentNum.add(r.nextInt(44)+1);
            if(presentNum.size() > 5){
                break;
            }
        }
        return presentNum;
    }
    public static void getLottoNum(int lottoCnt, LinkedList<LinkedList> lottoArr){
        Random r = new Random();
        for(int i=0; i<lottoCnt; i++){
            System.out.printf("%c\t", 'A'+i);
            HashSet hash = new HashSet();
            while(true){
                hash.add(r.nextInt(44)+1);
                if(hash.size() > 5){
                    break;
                }
            }
            LinkedList link = new LinkedList(hash);
            Collections.sort(link);
            for (int j = 0; j < link.size(); j++) {
                if(j != link.size()-1) {
                    System.out.printf("%02d,",link.get(j));
                }else{
                    System.out.printf("%02d\n",link.get(j));
                }
            }
            lottoArr.add(link);
        }
    }
    public static void getLottoPresent(LinkedList presentList){
        System.out.print("\n[로또 발표]\n\t");
        for(int i=0; i<presentList.size(); i++){
            if(i != 5) {
                System.out.printf("%02d,",presentList.get(i));
            }else{
                System.out.printf("%02d\n",presentList.get(i));
            }
        }
    }
    public static void getLottoResult(LinkedList<LinkedList> lottoArr, int lottoCnt, LinkedList presentList){
        // 내 로또 결과 계산
        int cnt[] = new int[lottoCnt];

        for(int i=0; i<lottoCnt; i++){
            for (int j = 0; j < presentList.size(); j++) {
                if(lottoArr.get(i).contains(presentList.get(j)))
                    cnt[i]++;
            }
        }

        System.out.println("\n[내 로또 결과]");
        for (int i = 0; i < cnt.length; i++) {
            System.out.printf("%c\t", 'A'+i);
            for (int j = 0; j < lottoArr.get(i).size(); j++) {
                if(j < lottoArr.get(i).size()) {
                    System.out.printf("%02d,", lottoArr.get(i).get(j));
                }else{
                    System.out.printf("%02d", lottoArr.get(i).get(j));
                }
            }
            System.out.println(" => "+cnt[i]+"개 일치");
        }
    }
}
