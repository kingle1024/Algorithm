package Programmers;

import java.util.*;
// 수박수박수박수박수박수?_https://programmers.co.kr/learn/courses/30/lessons/12922
public class PGM_12922 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }
    public static String solution(int n) {
        String answer = "";
        String temp[] = {"수","박"};

        for(int i=0; i<n; i++){
            answer += temp[i%2];
        }
        return answer;
    }
}
