package Programmers;

class PGM_76501{
    public static void main(String[] args) {

    }
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        answer = 0;
        for(int i=0; i<absolutes.length; i++){
            if(signs[i]){
                answer += absolutes[i];
            }else{
                answer += (absolutes[i] * -1);
            }
        }
        return answer;
    }
}