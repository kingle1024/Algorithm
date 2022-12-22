package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_25501 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        for(int i=1; i<=loop; i++){
            cnt = 1;
            String str = br.readLine();
            System.out.println(isPalindrom(str) + " " + cnt);
        }
    }
    public static int recursion(String str, int l, int r){
        if(l >= r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        else{
            cnt++;
            return recursion(str, l+1, r-1);
        }
    }

    public static int isPalindrom(String str){
        return recursion(str, 0, str.length()-1);
    }
}
