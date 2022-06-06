package ZeroBase.CodingTest;

import java.util.Arrays;

public class coding02_01 {
    /*
    촘촘이는 무엇이든 연속으로 가득찬 것을 좋아한다. 이번에 촘촘이가 빠진 취미는 빠짐없이 연속된 숫자를 모으는 것이다.

촘촘이는 연속된 숫자가 무작위 순서로 배치된 배열 numbers를 입력받았다.

이 배열에는 최소한 하나 이상 비어있는 숫자가 있으며, 배열에서 가장 작은 숫자는 알려져 있지 않다.

배열에서 비어있는 숫자 중, 가장 작은 숫자를 출력하는 프로그램을 작성하시오.


     */
    public static void main(String[] args) {
//        String s = "4abcdededededede";
//        System.out.println(s.length());
        String test = "aabbaccc";

//        solution("aabbaccc");
//        solution("ababcdcdababcdcd");
        solution(new String[]{"abcabcdede"});
    }
    public static int solution(String[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        boolean check = true;
        int lowNum = -1;
        for(int i=0; i<numbers.length-1; i++){
            if(numbers[i+1] != numbers[i]+1){
                check = false;
                lowNum = Integer.parseInt(numbers[i]+1);
                break;
            }
        }
        answer = lowNum;
        return answer;
    }
}
