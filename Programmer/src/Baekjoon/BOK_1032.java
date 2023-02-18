package Baekjoon;

import java.io.*;
import java.util.*;

public class BOK_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        String[] arr = new String[loop];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<loop; i++){
            arr[i] = br.readLine();
        }

        for (int i = 0; i < arr[0].length(); i++) {
            char c = arr[0].charAt(i);
            boolean check = false;
            for (int j = 0; j < loop; j++) {
                if(arr[j].charAt(i) != c){
                    check = true;
                    break;
                }
            }

            if(check){
                bw.write("?");
            }else{
                bw.write(c);
            }
        }

        bw.flush();
    }
}
