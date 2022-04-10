package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOK_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int sum = 0;
        String arr[] = new String[s.length()];
        String temp = "";

        for(int i=0; i<s.length(); i++){
            temp = s.charAt(i)+"";
            sum += Integer.parseInt(temp);
            arr[i] = temp;
        }
        Arrays.sort(arr, Collections.reverseOrder());

        if(sum %3 != 0 || Integer.parseInt(arr[arr.length-1]) != 0){
            System.out.println("-1");
        }else {
            temp = "";
            for (int i = 0; i < arr.length; i++) {
                temp += arr[i];
            }
            System.out.println(temp);
        }
    }
}
