package Programmers;

import java.util.*;
// 예산_https://programmers.co.kr/learn/courses/30/lessons/12982
public class PGM_12982 {
    public static void main(String[] args) {
//        solution([1,3,2,5,4],9);
    }
    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        int result = 0;
        for(int i=0; i<d.length; i++){
            if(budget >= (result + d[i])){
                result += d[i];
                answer++;
            }
        }
        return answer;
    }
}
