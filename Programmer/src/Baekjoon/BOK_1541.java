package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10-10+10-10+10 -> -30
// 30-70-20+40-10+100+30-35
public class BOK_1541 { // 잃어버린 괄호
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String temp = "";
        String arr[] = s.split("-");
        String addition[];
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i].indexOf('+')  > -1){
                addition = arr[i].split("\\+");
                for(int j=0; j<addition.length; j++){
                    sum += Integer.parseInt(addition[j]);
                }
                arr[i] = Integer.toString(sum);
                sum = 0;
            }
        }
        sum = Integer.parseInt(arr[0]);
        for(int i=1; i<arr.length; i++){
            sum -= Integer.parseInt(arr[i]);
        }
        System.out.println(sum);
    }
}
