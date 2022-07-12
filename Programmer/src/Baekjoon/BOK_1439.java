package Baekjoon;

import java.util.Scanner;

public class BOK_1439 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        solution(sc.next());
        solution("0001100");
        solution("11111");
        solution("00000001");
        solution("11001100110011000001");
        solution("11101101");
    }
    static void solution(String s){
        int cnt = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) != s.charAt(i+1)){
                cnt++;
            }
        }
        if(cnt != 1){
            System.out.println(cnt/2);
        }else{
            System.out.println(cnt);
        }
    }
}
