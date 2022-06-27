package ZeroBase.Class;

import java.util.Arrays;

/*
    문자열 s를 거꾸로 출력하는 프로그램
    입출력 예시
    문자열 : the sky is blue
    출력 : blue is sky the

    문자열 : hello java
    출력 : java hello

 */
public class Part2_Chapter04_Class07_Practice03 {
    public static String solution(String s){
        if(s == null) return null;
        if(s.length() < 2) return s;
        char[] cArr = s.toCharArray();
        reverseString(cArr, s.length()-1, s.length()-1);
        String result = "";
        for(int i=0; i<cArr.length; i++){
            result += cArr[i];
        }
        return result;
    }
    public static String removeSpaces(String s){
        return null;
    }
    public static void reverseString(char[] cArr, int i, int j){
        String r = "";
        while(true) {
            while (true) {
                if (cArr[j] == ' ') {
                    j--;
                } else {
                    i = j;
                    break;
                }
            }
            while (true) {
                if (i != 0 && cArr[i] != ' ') {
                    i--;
                } else {
                    for (int k = i; k <= j; k++) {
                        if(cArr[k] == ' ') continue;
                        r += cArr[k];
                    }
                    j = i-1;
                    break;
                }
//                System.out.println(r +" " + i +" ");
            }
            if(i == 0 || j == 0){
                break;
            }else{
                r += " ";
            }
        }
        cArr = r.toCharArray();
    }
    public static void main(String[] args) {
        System.out.println(solution("the sky is blue"));
        System.out.println(solution("  hello     java     "));
    }
}
