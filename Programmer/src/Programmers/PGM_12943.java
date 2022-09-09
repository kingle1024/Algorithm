package Programmers;

class PGM_12943{
    public static void main(String[] args) {

    }
    class Solution {
        public int solution(int num) {
            if(num == 1) return 0;
            int answer = 0;
            long toNum;
            int cnt = 0;
            toNum = num;
            while(true){
                if(toNum % 2 == 0){
                    toNum = toNum / 2;
                }else{
                    toNum = toNum * 3 + 1;
                }
                cnt++;

                if(toNum == 1) break;
                else if(cnt == 500) break;
            }
            // System.out.println(cnt);
            if(cnt == 500) return -1;
            answer = cnt;

            return answer;
        }
    }
}
