package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

/*

 */
public class BOK_1205 {
    public static void main(String[] args) {
        System.out.println(solution());
        /*
10 90 10
100 100 100 100 100 100 100 100 90 90
-> -1

10 90 10
100 100 100 100 100 100 100 100 100 90
-> -1

12 100 10
100 100 100 100 100 100 100 100 100 90 90 90
-> 1

3 70 10
100 90 80
-> 4

         */
    }
    static int solution(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 갯수 0~P
        int newScore = sc.nextInt(); // 태수의 점수 0 ~ 20억
        int P = sc.nextInt(); // 등수 갯수 10~50
        ArrayList<Integer> array = new ArrayList();

        // 배열이 0일 때에 예외처리
        if(N == 0){
            if(P < 1){
                return -1;
            }
            return 1;
        }

        for(int i=0; i<N; i++){
            array.add(sc.nextInt());
        }

        int idx = -1;
        int searchIdx = -1;
        if(array.size() < P){
            searchIdx = array.size();
        }else{
            searchIdx = P;
        }

        // newScore가 위치할 곳을 찾음
        for(int i=0 ; i < searchIdx; i++){
            if(array.get(i) == newScore){
                idx = i;
            }else if(array.get(i) < newScore){
                idx = i-1;
                break;
            }else if(i == searchIdx-1 && array.get(i) > newScore){ // 맨 마지막 숫자보다 작은 경우
                idx = i;
            }
        }

        // 해당 위치에 숫자 추가
        idx+=1;
        array.add(idx, newScore);
        // 추가한 위치가 P(등수) 보다 뒤에면
        if(idx+1 > P){
            return -1;
        }else {
            // 숫자 위치 확인
            int catchIdx = -1;
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) == newScore) {
                    catchIdx = i;
                    catchIdx++;
                    break;
                }
            }
            return catchIdx;
        }
    }
}
