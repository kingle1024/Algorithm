package ZeroBase.CodingTest;

import java.util.Arrays;

public class coding05_01 {
    public static void main(String[] args) {
        System.out.println(solution("imfinethankyou", "atfhinemnoyuki"));
    }
    static boolean solution(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        char[] arr = s.toCharArray();
        char[] arr2 = t.toCharArray();

        if(Arrays.toString(arr).equals(Arrays.toString(arr2))){
            return true;
        }else{
            return false;
        }
    }
}
