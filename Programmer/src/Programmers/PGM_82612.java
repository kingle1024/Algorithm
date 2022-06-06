public class PGM_82612 {
    public static void main(String[] args) {

    }
    public long solution(int price, int money, int count) {
        long answer = -1;
        long total = 0;
        for(int i=1; i<=count; i++){
            total += price*i;
        }

        if(total <= money){ // 0이상일때(money가 더 클 때)
            return 0;
        }else{ // 음수일때
            answer = total;
        }
        answer = total - money;

        return answer;
    }
}
