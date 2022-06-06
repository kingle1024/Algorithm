package Programmers;

import java.util.*;
// x만큼 간격이 있는 n개의 숫자_https://programmers.co.kr/learn/courses/30/lessons/12954
public class PGM_12954 {
    public static void main(String[] args) {
        long[] answer = solution(10000000,1000);
        for(int i=0; i< answer.length; i++){
            System.out.println(answer[i]);
        }
    }
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i=0; i<n; i++){
            answer[i] = x*(new Long(i)+1);
        }

        return answer;
    }
}
