package Programmers;

public class PGM_70129 {
    public static void main(String[] args) {
        solution("110010101001");
        solution("01110");
        solution("1111111");

//        System.out.println(getTwo(6));
//        System.out.println(getTwo(2));
//        System.out.println(getTwo(1));
    }
    public static int[] solution(String s) {
        int[] answer = {};
        StringBuffer sb = new StringBuffer();

        int lengthCnt = -1;
        int answerloopCnt = 0;
        int answerZeroCnt = 0;

        while(true) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    cnt++;
                    answerZeroCnt++;
                }
            }
            lengthCnt = s.length() - cnt;
            s = getTwo(lengthCnt);
            answerloopCnt += 1;
            if(s.length() == 1) break;
        }

//        System.out.println(answerloopCnt +" " + answerZeroCnt);
        answer = new int[2];
        answer[0] = answerloopCnt;
        answer[1] = answerZeroCnt;
        return answer;
    }
    public static String getTwo(int num){
        StringBuffer sb = new StringBuffer();
        while(true){
//            System.out.println("[1] "+num);
            int tempNum = num;
            num = tempNum / 2;
            int n = tempNum % 2;
            sb.insert(0,n);

            if(num == 0) break;
//            System.out.println("[2] "+num);
        }
        return String.valueOf(sb);
    }
}
