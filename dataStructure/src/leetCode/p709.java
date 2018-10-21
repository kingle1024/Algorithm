package leetCode;

public class p709 {
	public static void main(String[] args) {
		System.out.println(toLowerCase("al&phaBET"));
	}
    public static String toLowerCase(String str) {
    	if(str.length() == 0) return "";
        char[] strToChar = str.toCharArray();
        for(int i=0; i<strToChar.length; i++){
            if(strToChar[i] < 'a' && strToChar[i] >= 'A')
                strToChar[i] =  (char)(strToChar[i] + 32);
        }
        return String.valueOf(strToChar);
    }
}
