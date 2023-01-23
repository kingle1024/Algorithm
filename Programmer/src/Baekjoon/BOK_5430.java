package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOK_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            String[] replace = arr.substring(1, arr.length()-1).split(",");

            Deque<Integer> deque = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                deque.add(Integer.valueOf(replace[j]));
            }

            StringBuilder sb = new StringBuilder();
            boolean isReverse = false;
            boolean isError = false;
            for (int j = 0; j < p.length(); j++) {
                char c = p.charAt(j);
                if(c == 'R'){
                    isReverse = !isReverse;
                }else if(c == 'D'){
                    if(deque.isEmpty()){
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if(isReverse) deque.removeLast();
                    else deque.removeFirst();
                }
            }

            if(isError){
                result.append(sb);
            }else {
                sb.append("[");

                int size = deque.size();
                for (int j = 0; j < size; j++) {
                    if (isReverse) {
                        sb.append(deque.pollLast()).append(",");
                    } else {
                        sb.append(deque.pollFirst()).append(",");
                    }
                }
//                System.out.println("sb = " + sb);
//                System.out.println("sb.charAt(sb.length()-1) = " + sb.charAt(sb.length()-1));
                if(sb.charAt(sb.length()-1) == ',') sb.deleteCharAt(sb.length()-1);

                sb.append("]\n");
                result.append(sb);
            }
        }
        System.out.println(result);
    }
}
