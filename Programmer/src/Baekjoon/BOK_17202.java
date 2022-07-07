package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_17202 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<str2.length(); i++){
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }
        StringBuffer nextStr;
        int cnt = 0;
        while(true) {
            nextStr = new StringBuffer();
            for (int i = 0; i < sb.length()-1; i++) {
                int num1 = Integer.parseInt(String.valueOf(sb.charAt(i)));
                int num2 = Integer.parseInt(String.valueOf(sb.charAt(i+1)));
                if(num1+num2 >= 10) {
                    nextStr.append((num1 + num2 - 10));
                }else{
                    nextStr.append((num1 + num2));
                }
            }

//            System.out.println(sb + " " + nextStr);
            if(nextStr.length() == 2) break;
            sb = nextStr;

        }
        System.out.println(nextStr);
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
