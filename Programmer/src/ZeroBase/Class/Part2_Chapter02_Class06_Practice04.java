package ZeroBase.Class;

import java.util.Stack;

// 두 문자열 비교
// 단, #은 backspace로 바로 이전의 문자를 삭제하는 기능이라고 가정
public class Part2_Chapter02_Class06_Practice04 {
    public static boolean stringCompare(String s1, String s2){
        if(strBackspaceRemove(s1).equals(strBackspaceRemove(s2))){
            return true;
        }else {
            return false;
        }
    }
    public static Stack strBackspaceRemove(String s1){
        Stack stack = new Stack();
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            if(c == '#' && !stack.empty()){
                stack.pop();
            }else{
                stack.push(s1.charAt(i));
            }
        }
        return stack;
    }
    public static void main(String[] args) {
        // Test code
        String s1 = "tree";
        String s2 = "th#ree";
        System.out.println(stringCompare(s1, s2));

        s1 = "ab#a";
        s2 = "aab#";
        System.out.println(stringCompare(s1, s2));

        s1 = "wo#w";
        s2 = "ww#o";
        System.out.println(stringCompare(s1, s2));
    }
}
