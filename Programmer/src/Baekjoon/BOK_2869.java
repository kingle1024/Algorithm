package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOK_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split(" ");
        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);
        int V = Integer.parseInt(arr[2]);
        V -= A;
        if(V % (A-B) == 0 ){
            System.out.println(V/(A-B) + 1);
        }else{
            System.out.println(V/(A-B) + 2);
        }
        bf.close();
    }
}
