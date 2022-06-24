package ZeroBase.CodingTest;

import java.util.Arrays;
import java.util.Comparator;

public class coding05_02 {
    public static void main(String[] args) {

    }
    public static String solution(int[] numbers) {
        String answer = "";
        String strs[] = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s, String t1) {
                return (s+t1).compareTo(s+t1);
            }
        });
        if(strs[0].equals("0")) return "0";
//        StringBuffer sb = new StringBuffer();

        for(int i=0; i<strs.length; i++){
//            sb.append(strs[i]);
            answer += strs[i];
        }
        return answer;
    }
}
