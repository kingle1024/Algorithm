package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
5
3
2
1
4
5
+
+
+
-
-
-
+
-
+
-
 */
public class BOK_1874 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    static void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> q = new LinkedList();
        int num = Integer.parseInt(bf.readLine());
        Queue<Integer> sequence = new LinkedList();

        int maxNum = -1;
        for(int i=0; i<num; i++){
            sequence.add(Integer.parseInt(bf.readLine()));
        }
        Stack<Integer> stack = new Stack();

        boolean check = false;
        while(!sequence.isEmpty()){
            int sNum = sequence.poll();

            if(stack.empty()){
                if(!check) {
                    for (int i = 1; i <= sNum; i++) {
                        stack.add(i);
                        q.add("+");
                    }
                }else{
                    for(int i=maxNum+1; i<=sNum; i++){
                        stack.add(i);
                        q.add("+");
                    }
                }
                stack.pop();
                q.add("-");
                if(maxNum < sNum){
                    maxNum = sNum;
                }
                check = true;
            }else{
                if(stack.peek() == sNum){
                    stack.pop();
                    q.add("-");
                }else if(stack.peek() < sNum){
                    for(int i=maxNum+1; i<=sNum; i++){
                        stack.add(i);
                        q.add("+");
                    }
                    stack.pop();
                    q.add("-");
                    if(maxNum < sNum){
                        maxNum = sNum;
                    }
                }else{
                    System.out.println("NO");
                    return;
                }
            }
        }
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
