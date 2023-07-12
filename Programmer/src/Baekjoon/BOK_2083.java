package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1;
        StringTokenizer st;

        int age;
        int num2;
        String name;
        while(true){
            s1 = br.readLine();
            if(s1.equals("# 0 0"))  break;
            st = new StringTokenizer(s1);
            name = st.nextToken();
            age = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());

            if(age > 17 || num2 >= 80) System.out.println(name + " Senior");
            else System.out.println(name + " Junior");
        }
    }
}
