package ZeroBase.Class;

// 문자열 뒤집기

// 입출력 예시)
// 입력 : "Hello"
// 출력 : "olleH"

import java.util.Stack;

// 입력 : 1 3 5 7 9
// 출력 : 9 7 5 3 1
public class Part2_Chapter02_Class06_Practice01 {
    public static String reverseString(String str){

        Stack stack = new Stack();
        for(int i=0; i<str.length(); i++){
            stack.add(str.charAt(i));
        }
        String result = "";
        int stackSize = stack.size();
        while(!stack.empty()){
            result += stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        // Test Code
        String result = reverseString("Hello");
        System.out.println("result = " + result);

        result = reverseString("1 3 5 7 9");
        System.out.println("result = " + result);
    }
}
