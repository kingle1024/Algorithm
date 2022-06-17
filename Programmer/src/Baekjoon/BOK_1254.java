package Baekjoon;

import java.util.Scanner;
// abaa
// abaaaaa
// aaaabaa
// 팰린드롬 만들
public class BOK_1254 {
    public static void main(String[] args) {
        System.out.println(solution());
    }
    static int solution(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(palindrome(s)){
            return s.length();
        }

        for(int i=1; i<s.length(); i++) {
            if(palindrome(s.substring(i, s.length()))){
                return s.length()+i;
            }
        }
        return 0;
    }
    static boolean palindrome(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
