package Programmers;

// 진법 뒤집기
public class PGM_68935 {
    public static void main(String[] args) {
        solution(18);
        solution(45);
        solution(125);
        solution(1);
        solution(100000000);
    }
    public static int solution(int n) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        int copyN = n;
        while(true){
            if(copyN == 1){
                sb.insert(0, 1);
                break;
            }else if(copyN == 0) break;

            int mok = copyN / 3;
            int namozi = copyN - (mok * 3);
            sb.insert(0, namozi);
            copyN = mok;
        }
//        System.out.println("3진법:"+sb);
        sb = sb.reverse();
        long reverseNum = Long.parseLong(String.valueOf(sb));
        sb = new StringBuffer(String.valueOf(reverseNum));
        answer = 0;

        for(int i=0; i<sb.length(); i++){
            int number = Integer.parseInt(String.valueOf(sb.charAt(i)));
            answer += Math.pow(3, sb.length()-i-1) * number;
        }
        return answer;
    }
}
