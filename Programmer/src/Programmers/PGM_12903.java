package Programmers;

class PGM_12903{
    public static void main(String[] args) {

    }
    class Solution {
        public String solution(String s) {
            String answer = "";
            int mid = s.length()/2;
            if(s.length() %2 ==0){ // 짝수일 때
                answer = s.charAt(mid-1)+""+s.charAt(mid);
            }else{
                answer = s.charAt(mid)+"";
            }
            return answer;
        }
    }
}