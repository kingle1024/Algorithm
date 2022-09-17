package Programmers;

import java.util.Stack;

public class PGM_42883 {
    public static void main(String[] args) {
        solution("1924", 2);
        solution("1924", 2);
    }
    public static String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        while(true){
            String strNum = String.valueOf(number.charAt(cnt));
            int num = Integer.parseInt(strNum);
            if(!stack.isEmpty()){
                if(stack.peek() < num) {
                    boolean check = false;
                    while (!stack.isEmpty() && k >= 1) {
                        if (stack.peek() < num) {
                            stack.pop();
                            k--;
                        } else {
                            stack.push(num);
                            check = true;
                            break;
                        }
                    }
                    if(!check) {
                        stack.push(num);
                    }
                }else{
                    stack.push(num);
                }
            }else{
                stack.push(num);
            }
            cnt++;
            if(cnt >= number.length()) break;
        }
//        System.out.println(stack);
        for(int i=0; i<k; i++){
            stack.pop();
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
//        System.out.println(sb);
        return String.valueOf(sb);
    }
}
