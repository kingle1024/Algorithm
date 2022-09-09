package Programmers;

class PGM_12940{
    public static void main(String[] args) {

    }
    public int[] solution(int n, int m) {
        int[] answer = {};
        answer = new int[2];
        int max = 0;
        int min = 0;
        int commonFactor = 1; // 최대공약수
        int commonMultiple = 0; // 최소공배수

        // 최대공약수 구하는 로직
        if(n > m){
            min = m;
            max = n;
        }else{
            min = n;
            max = m;
        }

        for(int i=2; i<=min; i++){
            if(n%i == 0 && m%i ==0){
                commonFactor = i;
            }
        }
        answer[0] = commonFactor;

        // 최소공배수 구하는 로직
        int i = 1;
        while(true){
            if((max * i) % min == 0){
                answer[1] = max * i;
                break;
            }
            i++;
        }

        return answer;
    }
    // 2 12 42
    // 3  6 21
    //    2  7
}
