package ZeroBase.Class;

import java.util.ArrayDeque;
import java.util.Deque;

public class Part2_Chapter02_Class10_Practice02 {
    public static boolean checkPalindrome(String str){
        boolean result = true;
        Deque d = new ArrayDeque();
        for(int i=0; i<str.length(); i++){
            d.add(str.charAt(i));
        }
        while(true){
            if(d.isEmpty()) break;
            char first = (char) d.removeFirst();
            char last = 0;
            if(!d.isEmpty()){
                last = (char) d.removeLast();
                if(first != last){
                    result = false;
                    break;
                }
            }else{
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(checkPalindrome("a"));
        System.out.println(checkPalindrome("aba"));
        System.out.println(checkPalindrome("abba"));
        System.out.println(checkPalindrome("abab"));
        System.out.println(checkPalindrome("abccba"));
        System.out.println(checkPalindrome("madam"));

    }
}
