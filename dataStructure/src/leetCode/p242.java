package leetCode;

import java.util.Arrays;

public class p242 {
	public static void main(String[] args) {
		isAnagram("aa","bb");
	}
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        else if(s.length() == 1 && t.length() == 1){
            if(s.equals(t))
                return true;
            else
                return false;
        }
            
        char sToChar[] = s.toCharArray();
        char tToChar[] = t.toCharArray();
        Arrays.sort(sToChar);
        Arrays.sort(tToChar);
        String sString = String.valueOf(sToChar);
        String tString = String.valueOf(tToChar);
        if(sString.equals(tString)) {
            return true;
        }
        else {
            return false;
        }
    }
}
