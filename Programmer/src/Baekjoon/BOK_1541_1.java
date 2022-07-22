package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOK_1541_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solution(sc.next());
//        solution("55-50+40");
//        solution("10+20+30+40");
//        solution("00009-00009");
//        solution("55-50+40-50+40+30-1-2-30");
    }
    static void solution(String s){
        Stack stack = new Stack();
        String temp = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                stack.add(temp);
                stack.add(s.charAt(i)+"");
                temp = "";
            }else {
                temp += s.charAt(i);
            }
        }
        if(!temp.equals("")){
            stack.add(temp);
        }
        int plusTemp = 0;
        int stackPre = 0;
        ArrayList<Integer> array = new ArrayList();

        while(!stack.empty()){
            String stackTemp = (String)stack.pop();
            if(stackTemp.equals("+")){
                String nextPop = (String)stack.pop();
                plusTemp = Integer.parseInt(nextPop) + stackPre;
                stack.add(String.valueOf(plusTemp));
            }else if(stackTemp.equals("-")){
                if(plusTemp != 0){
                    array.add(plusTemp * -1);
                    plusTemp = 0;
                }else {
                    array.add(stackPre * -1);
                }
            }else{
                stackPre = Integer.parseInt(stackTemp);
            }
        }

        array.add(stackPre);
        int answer = 0;
        for(int i=0; i<array.size(); i++){
            answer += array.get(i);
        }
        System.out.println(answer);
    }
}
// 20 10 40 40