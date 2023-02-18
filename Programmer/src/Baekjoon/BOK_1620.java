package Baekjoon;

import java.io.*;
import java.util.*;

public class BOK_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());
        int resultLoop = Integer.parseInt(st.nextToken());

        String[] strArr = new String[loop+1];
        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 1; i <= loop; i++) {
            String s = br.readLine();
            strArr[i] = s;
            hashMap.put(s, i);
        }


        for (int i = 0; i < resultLoop; i++) {
            String s = br.readLine();
            char c = s.charAt(0);
            int cNUm = c;
            if(cNUm >= 'A' && cNUm <= 'z'){
                int num = hashMap.get(s);
                bw.write(String.valueOf(num));
            }else{
                String ss = strArr[Integer.parseInt(s)];
                bw.write(ss);
            }
            bw.write("\n");
        }
//        System.out.println("hashMap = " + hashMap);
        bw.flush();

    }
}
