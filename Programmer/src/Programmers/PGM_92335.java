package Programmers;

public class PGM_92335 {
    public static void main(String[] args) {
//        solution(437674,3);
//        solution(110011,10);

//        for (int i = 90000; i < 100001; i++) {
//            for (int j = 3; j < 11; j++) {
//                solution(i, j);
//            }
//        }
        solution(885733, 3);

    }
    public static int solution(int n, int k) {
        int answer = -1;
        StringBuffer sb = new StringBuffer();

        while(true){
            long remainder = n % k;
            sb.insert(0, remainder);
            n = n / k;

            if(n == 0) break;
        }
        System.out.println(sb);
        String str = String.valueOf(sb);
        String[] arrStr = str.split("0");
        int cnt = 0;
        for(int i=0; i<arrStr.length; i++){
//            System.out.print(arrStr[i] +" ");
            if(arrStr[i].equals("")) continue;
            long num = Long.parseLong(arrStr[i]);
            if(num != 1) {
                if(decimal(num)) {
//                    System.out.println(num);
                    cnt++;
                }
            }
        }
//        System.out.println(cnt);
        answer = cnt;
        return answer;
    }
    public static boolean decimal(long num){
        for(int i=3; i<=Math.sqrt(num); i+=2){
            if(num%i == 0) return false;
        }
        return true;
    }
}
