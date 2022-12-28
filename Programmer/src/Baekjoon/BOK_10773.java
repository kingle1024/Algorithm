package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOK_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<loop; i++){
            int value = Integer.parseInt(br.readLine());
            if(value == 0){
                stack.pop();
            }else{
                stack.push(value);
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        System.out.println(result);
    }
}
