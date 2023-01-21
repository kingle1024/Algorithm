package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOK_17413 {
    public static void main(String[] args) throws IOException {
        boolean isOpen = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '<'){
                if(sb.length() != 0){
                    arrayList.add(String.valueOf(sb.reverse()));
                    sb = new StringBuilder();
                }
                isOpen = true;
                sb.append("<");
            }else if(c == '>'){
                isOpen = false;
                sb.append(">");
                arrayList.add(String.valueOf(sb));
                sb = new StringBuilder();
            }else if(!isOpen && c == ' '){
                arrayList.add(sb.reverse().toString());
                arrayList.add(" ");
                sb = new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        if(sb.length() != 0) arrayList.add(String.valueOf(sb.reverse()));

        for (String value : arrayList) {
            System.out.print(value);
        }

    }
}
